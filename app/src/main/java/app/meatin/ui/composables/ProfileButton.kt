package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.R
import app.meatin.ui.theme.DisableLightGray2
import app.meatin.ui.theme.Typography
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.net.URI

@ExperimentalCoilApi
@Composable
fun ProfileButton(
    modifier: Modifier = Modifier,
    profileUri: URI,
    badgeUri: URI,
    onClick: () -> Unit,
    classes: String,
    classesColor: Color,
    username: String
) {
    ConstraintLayout(
        modifier
            .size(343.dp, 55.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable { onClick() }
            .background(Color.White)
    ) {
        val (
            badgeImage,
            profileImage,
            classesText,
            usernameText,
            rightArrow
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
        Image(
            modifier = Modifier
                .size(18.dp, 15.dp)
                .constrainAs(badgeImage) {
                    start.linkTo(profileImage.end, 12.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            painter = rememberImagePainter(
                data = badgeUri.toASCIIString()
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .constrainAs(classesText) {
                    start.linkTo(badgeImage.end, 4.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            overflow = TextOverflow.Ellipsis,
            style = Typography.body2,
            color = classesColor,
            text = classes,
            maxLines = 1
        )
        Text(
            modifier = Modifier
                .constrainAs(usernameText) {
                    start.linkTo(classesText.end, 4.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            overflow = TextOverflow.Ellipsis,
            style = Typography.body2,
            text = username
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
        badgeUri = URI("https://ychef.files.bbci.co.uk/976x549/p04kt0s1.jpg"),
        onClick = {},
        classes = "유사 백선생",
        classesColor = Color(0xFFFFA318),
        username = "김응애"
    )
}
