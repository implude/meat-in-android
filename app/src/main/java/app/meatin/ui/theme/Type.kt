package app.meatin.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import app.meatin.R

val NotoSansFontFamily = FontFamily(
    Font(R.font.noto_sans_cjk_kr_regular, FontWeight.Normal),
    Font(R.font.noto_sans_cjk_kr_medium, FontWeight.Medium),
    Font(R.font.noto_sans_cjk_kr_bold, FontWeight.Bold),
)

@Deprecated("Use MeatInTypography instead.")
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = Color.Black,
    ),
    h2 = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color.Black.copy(alpha = 0.6f),
    ),
    body1 = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = Color.Black,
    ),
    body2 = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.Black,
    ),
    caption = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = Color.Black.copy(alpha = 0.4f),
    ),
)

object MeatInTypography {
    private const val AUTO_LINE_HEIGHT = 1.5

    val pageTitle = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = (20 * AUTO_LINE_HEIGHT).sp,
        letterSpacing = (-0.01).sp,
        color = Color.Black,
    )
    val sectionHeader = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = (16 * AUTO_LINE_HEIGHT).sp,
        letterSpacing = (-0.01).sp,
        color = Color.Black,
    )
    val subHeader = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = (14 * AUTO_LINE_HEIGHT).sp,
        letterSpacing = (-0.01).sp,
        color = Color.Black.copy(alpha = 0.6f),
    )
    val bigDescription = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = (20 * AUTO_LINE_HEIGHT).sp,
        letterSpacing = (-0.01).sp,
        color = Color.Black,
    )
    val regularImportant = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = (14 * AUTO_LINE_HEIGHT).sp,
        letterSpacing = (-0.01).sp,
        color = Color.Black,
    )
    val regular = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = (14 * AUTO_LINE_HEIGHT).sp,
        letterSpacing = (-0.03).sp,
        color = Color.Black,
    )
    val description = TextStyle(
        fontFamily = NotoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = (14 * 1.35).sp,
        letterSpacing = (-0.03).sp,
        color = Color.Black.copy(alpha = 0.4f),
    )
}
