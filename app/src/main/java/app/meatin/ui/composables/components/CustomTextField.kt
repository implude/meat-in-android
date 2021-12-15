package app.meatin.ui.composables.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import app.meatin.ui.theme.BorderGray
import app.meatin.ui.theme.ErrorRed
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText

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
