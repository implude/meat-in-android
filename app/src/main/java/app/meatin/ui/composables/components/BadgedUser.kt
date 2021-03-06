package app.meatin.ui.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.domain.model.BriefCommunityUser
import app.meatin.domain.model.FakeValues
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun BadgedUser(
    modifier: Modifier = Modifier,
    user: BriefCommunityUser,
    labelColor: Color = Color(0xFFFFA318), // TODO temporary hard-coded color
    nameColor: Color = Color.Black,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .height(18.dp)
                .width(18.dp),
            painter = rememberImagePainter(
                data = user.repBadge?.image
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        CoreText(
            modifier = Modifier
                .padding(start = 4.dp),
            text = user.repBadge?.label ?: "",
            overflow = TextOverflow.Ellipsis,
            style = MeatInTypography.regular,
            color = labelColor,
            maxLines = 1
        )
        Spacer(modifier = Modifier.width(4.dp))
        CoreText(
            text = user.name,
            overflow = TextOverflow.Ellipsis,
            style = MeatInTypography.regularImportant,
            color = nameColor,
            maxLines = 1
        )
    }
}

@ExperimentalCoilApi
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun BadgedUserPreview() {
    BadgedUser(
        user = FakeValues.BRIEF_COMMUNITY_USER
    )
}
