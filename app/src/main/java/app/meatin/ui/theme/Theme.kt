package app.meatin.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = DarkFlamingo,
    primaryVariant = Flamingo,
    error = ErrorRed,
    background = BackgroundFullBrightGray,
)

@Composable
fun MeatInTheme(content: @Composable () -> Unit) {
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
