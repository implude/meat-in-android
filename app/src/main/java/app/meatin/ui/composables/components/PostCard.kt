package app.meatin.ui.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.meatin.domain.model.BriefBadge
import app.meatin.domain.model.BriefCommunityUser
import app.meatin.domain.model.BriefRecipe
import app.meatin.domain.model.Comment
import app.meatin.domain.model.Difficulty
import app.meatin.domain.model.Heart
import app.meatin.domain.model.MeatType
import app.meatin.domain.model.Post
import app.meatin.ui.theme.DarkFlamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import app.meatin.util.defaultDateFormatter
import app.meatin.util.toDate
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    post: Post,
    onClick: () -> Unit,
) {
    Card(
        modifier
            .requiredHeight(302.dp)
            .requiredWidth(375.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable { onClick() },
        backgroundColor = Color.White,
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            val dateStr: String = defaultDateFormatter.format(post.createdAt.toDate())
            Column(Modifier.align(Alignment.TopStart)) {
                Row {
                    Image(
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .clip(CircleShape),
                        painter = rememberImagePainter(
                            data = post.author.profileImage
                        ),
                        contentDescription = null
                    )
                    Column {
                        BadgedUser(user = post.author)
                        Spacer(modifier = Modifier.height(4.dp))
                        CoreText(
                            text = dateStr,
                            overflow = TextOverflow.Ellipsis,
                            style = MeatInTypography.regular,
                            maxLines = 1,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                CoreText(
                    text = post.content,
                    overflow = TextOverflow.Ellipsis,
                    style = MeatInTypography.regular,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Image(
                    modifier = Modifier
                        .height(170.dp)
                        .width(343.dp),
                    painter = rememberImagePainter(
                        data = post.photos.first()
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    val heartIcon = if (post.heart.hearted) {
                        Icons.Default.Favorite
                    } else {
                        Icons.Default.FavoriteBorder
                    }
                    Icon(
                        modifier = Modifier
                            .padding(end = 2.dp)
                            .size(12.dp),
                        imageVector = heartIcon,
                        contentDescription = null,
                        tint = DarkFlamingo,
                    )
                    CoreText(
                        text = post.heart.count.toString(),
                        style = MeatInTypography.regularImportant
                            .copy(fontSize = 12.sp),
                        color = DarkFlamingo,
                    )
                    Spacer(modifier = Modifier.width(11.dp))
                    Icon(
                        modifier = Modifier
                            .padding(end = 2.dp)
                            .size(12.dp),
                        imageVector = Icons.Default.Send,
                        contentDescription = null,
                        tint = Color.Gray,
                    )
                    CoreText(
                        text = post.comments.size.toString(),
                        style = MeatInTypography.regularImportant
                            .copy(fontSize = 12.sp),
                        color = Color.Gray,
                    )
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun PostCardPreview() {
    PostCard(
        modifier = Modifier.padding(10.dp),
        post = Post(
            photos = listOf("https://www.nemopan.com/files/attach/images/166591/207/339/014/e96e99e30becc3f29b8b6a4e1e20c1f8.jpg"),
            author = BriefCommunityUser(
                name = "김응애", profileImage = "sample uri",
                repBadge = BriefBadge("sample uri", "유사 백선생")
            ),
            heart = Heart(40, true),
            comments = List(50) { Comment("", 0, BriefCommunityUser("", "", BriefBadge("", "")), "") },
            content = "응애",
            title = "응애",
            createdAt = 0,
            linkedRecipe = BriefRecipe("", "", MeatType(""), 0, Difficulty("", 0), 0, Heart(0, false)),
            bookmarked = true,
        ),
        onClick = { },
    )
}
