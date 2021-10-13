package app.meatin.ui.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.domain.model.BriefBadge
import app.meatin.domain.model.BriefCommunityUser
import app.meatin.domain.model.CommunityUser
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun BadgedUser(user: BriefCommunityUser) {
    Row {
        Image(
            modifier = Modifier
                .height(18.dp)
                .width(18.dp),
            painter = rememberImagePainter(
                data = user.repBadge.image
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        CoreText(
            text = user.repBadge.label,
            overflow = TextOverflow.Ellipsis,
            style = MeatInTypography.regular,
            color = Color(0xFFFFA318), // TODO temporary hard-coded color
            maxLines = 1
        )
        Spacer(modifier = Modifier.width(4.dp))
        CoreText(
            text = user.name,
            overflow = TextOverflow.Ellipsis,
            style = MeatInTypography.regularImportant,
            maxLines = 1
        )
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun BadgedUserPreview() {
    BadgedUser(
        BriefCommunityUser(
            name = "김응애", profileImage = "sample uri",
            repBadge = BriefBadge("sample uri", "유사 백선생")
        )
    )
}