package app.meatin.ui.composables

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.ui.composables.components.CustomTextField
import app.meatin.ui.theme.BorderGray
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.LightFlamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import app.meatin.util.emailRegex

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreen(
    registerState: RegisterState,
    onEmailConfirm: (String) -> Unit,
    onPasswordConfirm: (String) -> Unit,
    onBackPressedInPassword: () -> Unit,
    onBackPressedInPasswordVerify: () -> Unit,
    onCredentialConfirm: (email: String, password: String) -> Unit,
) {
    val localUriHandler = LocalUriHandler.current
    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    val (passwordVerify, setPasswordVerify) = remember { mutableStateOf("") }

    val (nicknameField, passwordField, passwordVerifyField) = remember { FocusRequester.createRefs() }

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
                text = when (registerState) {
                    RegisterState.EMAIL -> "???????????? ??????????????????"
                    RegisterState.PASSWORD -> "??????????????? ??????????????????"
                    RegisterState.PASSWORD_VERIFY -> "??????????????? ?????? ??????????????????"
                },
                style = MeatInTypography.sectionHeader,
                modifier = Modifier.fillMaxWidth()
            )

            AnimatedVisibility(
                visible = registerState == RegisterState.PASSWORD_VERIFY,
            ) {
                CustomTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                        .focusRequester(passwordVerifyField),
                    value = passwordVerify,
                    onValueChange = {
                        setPasswordVerify(it.replace("""[^\u0021-\u007e]""".toRegex(), ""))
                    },
                    placeholder = {
                        CoreText(
                            "??????????????? ?????? ??????????????????",
                            color = BorderGray,
                            style = MeatInTypography.regularImportant
                        )
                    },
                    keyboardActions = KeyboardActions {
                        onCredentialConfirm(email, password)
                        keyboardController?.hide()
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done,
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    isError = password != passwordVerify && password.isNotEmpty(),
                    errorMessage = "??????????????? ???????????? ????????????"
                )
                DisposableEffect(Unit) {
                    setPasswordVerify("")
                    passwordVerifyField.requestFocus()
                    onDispose { }
                }
                BackHandler {
                    onBackPressedInPasswordVerify()
                }
            }

            AnimatedVisibility(
                visible = registerState == RegisterState.PASSWORD || registerState == RegisterState.PASSWORD_VERIFY,
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
                        CoreText(
                            "${minPasswordThreshold}?????? ?????? ??????????????????",
                            color = BorderGray,
                            style = MeatInTypography.regularImportant
                        )
                    },
                    keyboardActions = KeyboardActions {
                        onPasswordConfirm(password)
                        keyboardController?.hide()
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next,
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    isError = password.length < minPasswordThreshold && password.isNotEmpty(),
                    errorMessage = "${minPasswordThreshold}?????? ?????? ??????????????????"
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
                value = email,
                onValueChange = {
                    setEmail(it.replace("""[\r\n\t]""".toRegex(), ""))
                },
                placeholder = {
                    CoreText("???????????? ??????????????????", color = BorderGray, style = MeatInTypography.regularImportant)
                },
                keyboardActions = KeyboardActions {
                    onEmailConfirm(email)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                ),
                isError = !email.matches(emailRegex) &&
                    (registerState == RegisterState.PASSWORD || registerState == RegisterState.PASSWORD_VERIFY || email.isNotEmpty()),
                errorMessage = "????????? ????????? ?????? ????????????"
            )

            DisposableEffect(Unit) {
                nicknameField.requestFocus()
                onDispose { }
            }
        }

        val isConfirmButtonEnabled =
            email.length >= minNicknameThreshold &&
                (registerState == RegisterState.EMAIL || email.matches(emailRegex))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            CoreText(
                text = "???????????? ??? ",
                style = MeatInTypography.description
            )
            CoreText(
                text = "???????????? ??????",
                style = MeatInTypography.description.copy(
                    color = Color.Black,
                    textDecoration = TextDecoration.Underline
                ),
                onClick = {
                    localUriHandler.openUri("https://meatin.app/policy")
                }
            )
            CoreText(
                text = "??? ???????????????.",
                style = MeatInTypography.description
            )
        }

        Button(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(),
            onClick = {
                when (registerState) {
                    RegisterState.EMAIL -> onEmailConfirm(email)
                    RegisterState.PASSWORD -> onPasswordConfirm(password)
                    RegisterState.PASSWORD_VERIFY -> onCredentialConfirm(email, password)
                }
            },
            shape = RectangleShape,
            enabled = isConfirmButtonEnabled,
            colors = ButtonDefaults.buttonColors(backgroundColor = Flamingo, disabledBackgroundColor = LightFlamingo)
        ) {
            CoreText(text = "??????", style = MeatInTypography.sectionHeader, color = Color.White)
        }
    }
}

enum class RegisterState {
    EMAIL,
    PASSWORD,
    PASSWORD_VERIFY,
}

@Preview
@Composable
fun RegisterScreenPreview() {
    var registerState by remember { mutableStateOf(RegisterState.EMAIL) }

    RegisterScreen(
        registerState,
        onEmailConfirm = { registerState = RegisterState.PASSWORD },
        onPasswordConfirm = { registerState = RegisterState.PASSWORD_VERIFY },
        onCredentialConfirm = { _, _ -> },
        onBackPressedInPassword = { registerState = RegisterState.EMAIL },
        onBackPressedInPasswordVerify = { registerState = RegisterState.PASSWORD },
    )
}
