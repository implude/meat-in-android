package app.meatin.ui.composables

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.ui.theme.BorderGray
import app.meatin.ui.theme.ErrorRed
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.LightFlamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    loginState: LoginState,
    onNicknameConfirm: (String) -> Unit,
    onBackPressedInPassword: () -> Unit,
    onCredentialConfirm: (nickname: String, password: String) -> Unit,
) {
    val (nickname, setNickname) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }

    val (nicknameField, passwordField) = remember { FocusRequester.createRefs() }

    val keyboardController = LocalSoftwareKeyboardController.current

    val minNicknameThreshold = 2
    val minPasswordThreshold = 8

    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(top = 160.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CoreText(
                text = when (loginState) {
                    LoginState.NICKNAME -> "닉네임을 입력해주세요"
                    LoginState.PASSWORD -> "비밀번호를 입력해주세요"
                },
                style = MeatInTypography.sectionHeader,
                modifier = Modifier.fillMaxWidth()
            )

            AnimatedVisibility(
                visible = loginState == LoginState.PASSWORD,
            ) {
                CustomTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                        .focusRequester(passwordField),
                    value = password,
                    onValueChange = {
                        setPassword(it.replace("""[^\u0021-\u007e]""".toRegex(), ""))
                    },
                    placeholder = {
                        CoreText("${minPasswordThreshold}글자 이상 입력해주세요",
                            color = BorderGray,
                            style = MeatInTypography.regularImportant)
                    },
                    keyboardActions = KeyboardActions {
                        onCredentialConfirm(nickname, password)
                        keyboardController?.hide()
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done,
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    isError = password.length < minPasswordThreshold && password.isNotEmpty(),
                    errorMessage = "${minPasswordThreshold}글자 이상 입력해주세요"
                )
                DisposableEffect(Unit) {
                    setPassword("")
                    passwordField.requestFocus()
                    onDispose { }
                }
                BackHandler {
                    onBackPressedInPassword()
                }
            }

            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .focusRequester(nicknameField),
                value = nickname,
                onValueChange = {
                    setNickname(it.replace("""[\r\n\t]""".toRegex(), ""))
                },
                placeholder = {
                    CoreText("2글자 이상 입력해주세요", color = BorderGray, style = MeatInTypography.regularImportant)
                },
                keyboardActions = KeyboardActions {
                    onNicknameConfirm(nickname)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                ),
                isError = nickname.length < minNicknameThreshold &&
                    (loginState == LoginState.PASSWORD || nickname.isNotEmpty()),
                errorMessage = "${minNicknameThreshold}글자 이상 입력해주세요"
            )

            DisposableEffect(Unit) {
                nicknameField.requestFocus()
                onDispose { }
            }
        }

        val isConfirmButtonEnabled =
            nickname.length >= minNicknameThreshold &&
                (loginState == LoginState.NICKNAME || password.length >= minPasswordThreshold)

        Button(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(),
            onClick = {
                when (loginState) {
                    LoginState.NICKNAME -> onNicknameConfirm(nickname)
                    LoginState.PASSWORD -> onCredentialConfirm(nickname, password)
                }
            },
            shape = RectangleShape,
            enabled = isConfirmButtonEnabled,
            colors = ButtonDefaults.buttonColors(backgroundColor = Flamingo, disabledBackgroundColor = LightFlamingo)
        ) {
            CoreText(text = "확인", style = MeatInTypography.sectionHeader, color = Color.White)
        }
    }
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable () -> Unit,
    keyboardActions: KeyboardActions,
    keyboardOptions: KeyboardOptions,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean = false,
    errorMessage: String = "",
) {
    val (isFocused, setFocused) = remember { mutableStateOf(false) }

    Column {
        BasicTextField(
            modifier = modifier.then(
                Modifier
                    .onFocusChanged { setFocused(it.isFocused) }
                    .fillMaxWidth()
            ),
            value = value, onValueChange = onValueChange,
            singleLine = true,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            decorationBox = { innerTextField ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        if (value.isEmpty()) {
                            placeholder()
                        }
                        innerTextField()
                    }

                    if (isError) {
                        Icon(
                            imageVector = Icons.Default.Warning, contentDescription = null,
                            tint = ErrorRed,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val (width, height) = this.size
                    drawLine(
                        color = if (isError) ErrorRed else if (isFocused) Flamingo else BorderGray,
                        start = Offset(0f, height - 1.dp.toPx()), end = Offset(width, height - 1.dp.toPx()),
                        strokeWidth = 2.dp.toPx()
                    )
                }
            }
        )

        if (isError) {
            CoreText(
                text = errorMessage,
                style = MeatInTypography.description, color = ErrorRed
            )
        }
    }
}

enum class LoginState {
    NICKNAME,
    PASSWORD,
}

@Preview
@Composable
fun LoginScreenPreview() {
    var loginState by remember { mutableStateOf(LoginState.NICKNAME) }

    LoginScreen(
        loginState,
        onNicknameConfirm = { loginState = LoginState.PASSWORD },
        onBackPressedInPassword = { loginState = LoginState.NICKNAME },
        onCredentialConfirm = { _, _ -> }
    )
}
