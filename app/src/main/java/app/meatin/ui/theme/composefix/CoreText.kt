package app.meatin.ui.theme

import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.updatePadding
import app.meatin.R
import kotlin.math.roundToInt

@Composable
fun CoreText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = MeatInTypography.regular,
    onClick: (() -> Unit)? = null,
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            TextView(context)
        },
        update = {
            it.setTextAppearance(style.fontWeight.toStyle())

            if (overflow == TextOverflow.Ellipsis) {
                it.ellipsize = TextUtils.TruncateAt.END
            }

            if (textDecoration != null) {
                it.paintFlags = when (textDecoration) {
                    TextDecoration.Underline -> {
                        Paint.UNDERLINE_TEXT_FLAG
                    }
                    TextDecoration.LineThrough -> {
                        Paint.STRIKE_THRU_TEXT_FLAG
                    }
                    else -> 0
                }
            }

            if (onClick != null) {
                it.setOnClickListener { onClick.invoke() }
            }

            if (color != Color.Unspecified || style.color != Color.Unspecified) {
                it.setTextColor(if (color == Color.Unspecified) style.color.toArgb() else color.toArgb())
            }

            it.textSize = style.fontSize.value
            it.text = text
            it.background = ColorDrawable(style.background.toArgb())
            it.maxLines = maxLines
            it.includeFontPadding = false
            it.syncLineHeight(style.lineHeight, 0.6207f)
            it.letterSpacing = style.letterSpacing.value
            it.textAlignment = textAlign?.toStyle() ?: style.textAlign.toStyle()
        }
    )
}

fun TextView.syncLineHeight(figmaLineHeight: TextUnit, factor: Float = 1.48f) {
    val lineHeight = when (figmaLineHeight.type) {
        TextUnitType.Sp -> figmaLineHeight.value
        TextUnitType.Em -> figmaLineHeight.value * 16
        else -> 0f
    }

    val lineSpacingExtra =
        lineHeight - factor * this.textSize

    val padding = lineSpacingExtra
        .takeIf { it != 0.0f }
        ?.div(2)
        ?.roundToInt()
        ?: 0

    setLineSpacing(lineSpacingExtra, 1f)
    updatePadding(
        top = padding,
        bottom = padding
    )
}

fun FontWeight?.toStyle(): Int {
    return when (this) {
        FontWeight.Bold -> R.style.TextStyleBold
        FontWeight.Normal -> R.style.TextStyleRegular
        FontWeight.Medium, FontWeight.SemiBold -> R.style.TextStyleMedium
        else -> -1
    }
}

fun TextAlign?.toStyle(): Int {
    return when (this) {
        TextAlign.Left -> View.TEXT_ALIGNMENT_TEXT_START
        TextAlign.Right -> View.TEXT_ALIGNMENT_TEXT_END
        TextAlign.Center -> View.TEXT_ALIGNMENT_CENTER
        TextAlign.Start -> View.TEXT_ALIGNMENT_TEXT_START
        TextAlign.End -> View.TEXT_ALIGNMENT_TEXT_END
        else -> -1
    }
}
