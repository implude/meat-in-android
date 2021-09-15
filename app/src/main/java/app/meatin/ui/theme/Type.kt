package app.meatin.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import app.meatin.R

val PretendardFontFamily = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    Font(R.font.pretendard_regular, FontWeight.Normal),
)
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = PretendardFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = Color.Black,
    ),
    h2 = TextStyle(
        fontFamily = PretendardFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color.Black.copy(alpha = 0.6f),
    ),
    body1 = TextStyle(
        fontFamily = PretendardFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = Color.Black,
    ),
    body2 = TextStyle(
        fontFamily = PretendardFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.Black,
    ),
    caption = TextStyle(
        fontFamily = PretendardFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.Black.copy(alpha = 0.4f),
    ),
)
