package app.meatin.ui.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import app.meatin.R
import app.meatin.domain.model.BriefBadge
import app.meatin.domain.model.BriefCommunityUser
import app.meatin.ui.theme.DisableLightGray2
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.net.URI

@ExperimentalCoilApi
@Composable
fun ProfileButton(
    modifier: Modifier = Modifier,
    user: BriefCommunityUser,
    profileUri: URI,
    onClick: () -> Unit,
) {
    ConstraintLayout(
        modifier
            .size(343.dp, 55.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable { onClick() }
            .background(Color.White)
    ) {
        val (
            profileImage,
            badgedUser,
            rightArrow,
        ) = createRefs()
        Image(
            modifier = Modifier
                .size(31.dp, 31.dp)
                .clip(CircleShape)
                .background(DisableLightGray2)
                .constrainAs(profileImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start, 16.dp)
                },
            painter = rememberImagePainter(
                data = profileUri.toASCIIString()
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        BadgedUser(
            modifier = Modifier.constrainAs(badgedUser) {
                top.linkTo(parent.top)
                start.linkTo(profileImage.end, 16.dp)
                bottom.linkTo(parent.bottom)
                end.linkTo(rightArrow.start)
                width = Dimension.fillToConstraints
            },
            user = user
        )
        Icon(
            modifier = Modifier
                .constrainAs(rightArrow) {
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            tint = Color(0xFFDFDFDF),
            painter = painterResource(R.drawable.ic_right_arrow),
            contentDescription = null
        )
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun ProfileButtonPreview() {
    ProfileButton(
        profileUri = URI("https://ychef.files.bbci.co.uk/976x549/p04kt0s1.jpg"),
        onClick = {},
        user = BriefCommunityUser(
            name = "김응애", profileImage = "sample uri",
            repBadge = BriefBadge("sample uri", "유사 백선생")
        ),
    )
}
