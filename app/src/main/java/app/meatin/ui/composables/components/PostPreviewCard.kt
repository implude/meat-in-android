package app.meatin.ui.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.meatin.R
import app.meatin.domain.model.BriefCommunityUser
import app.meatin.domain.model.BriefPost
import app.meatin.domain.model.FakeValues
import app.meatin.domain.model.Heart
import app.meatin.ui.theme.BoxTextDarkGray
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import app.meatin.util.defaultDateFormatter
import app.meatin.util.toDate
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PostPreviewCard(
    modifier: Modifier = Modifier,
    post: BriefPost,
) {
    Column(
        modifier.then(
            Modifier.background(Color.White)
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PostHeader(post.author, post.createdAt)
        CoreText(post.content)

        if (post.photo != null) {
            Image(
                contentScale = ContentScale.FillWidth,
                painter = rememberImagePainter(data = post.photo), contentDescription = "Preview image"
            )
        }
        ExtraInfo(post.heart, post.nComments)
    }
}

@Composable
private fun ExtraInfo(heart: Heart, nComments: Int) =
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
        val heartIcon = if (heart.hearted) {
            painterResource(id = R.drawable.ic_heart2_filled)
        } else {
            painterResource(id = R.drawable.ic_heart2)
        }

        IconText(
            painter = heartIcon, iconSize = 12.dp,
            text = heart.count.toString(), fontSize = 12.sp,
            color = Flamingo,
            contentDescription = if (heart.hearted) "Hearted" else "Not hearted",
        )
        IconText(
            painter = painterResource(id = R.drawable.ic_comment), iconSize = 12.dp,
            text = nComments.toString(), fontSize = 12.sp,
            color = BoxTextDarkGray,
            contentDescription = "Comments",
        )
    }

@Composable
fun IconText(
    painter: Painter,
    iconSize: Dp,
    text: String,
    fontSize: TextUnit,
    color: Color,
    contentDescription: String,
) = Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
    Icon(
        modifier = Modifier.size(iconSize),
        painter = painter, contentDescription = contentDescription,
        tint = color,
    )
    Text(text, color = color, fontSize = fontSize)
}

@ExperimentalCoilApi
@Composable
private fun PostHeader(user: BriefCommunityUser, date: Long) =
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            painter = rememberImagePainter(data = user.profileImage), contentDescription = "User profile image",
        )
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            BadgedUser(user = user)
            CoreText(defaultDateFormatter.format(date.toDate()), style = MeatInTypography.description)
        }
    }

@Preview
@Composable
fun PPCPreview() = Surface(Modifier.background(Color.Gray)) {
    PostPreviewCard(
        modifier = Modifier
            .width(343.dp)
            .wrapContentHeight()
            .padding(10.dp)
            .clickable { },
        post = FakeValues.BRIEF_POST,
    )
}
