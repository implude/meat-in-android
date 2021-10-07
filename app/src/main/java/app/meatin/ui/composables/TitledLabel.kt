package app.meatin.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.ui.theme.CoreText
import app.meatin.ui.theme.MeatInTypography


@Composable
fun TitledLabel(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    onClick: () -> Unit,

    ) {
    Box(
        modifier
            .height(37.dp)
            .widthIn(max = 303.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable { onClick() }
            .background(Color(0xFFF9F9F9))

    ) {
        Row(
            modifier
                .align(Alignment.Center)
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            CoreText(
                text = title,
                style = MeatInTypography.regularImportant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(
                modifier
                    .size(8.dp)
            )
            CoreText(
                text = subtitle,
                style = MeatInTypography.regular,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@Composable
fun TitledLabelPreview() {
    TitledLabel(
        title = "부위",
        subtitle = "머릿고기",
        onClick = {},
    )
}
