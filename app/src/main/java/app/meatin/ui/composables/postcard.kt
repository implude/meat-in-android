
package androidx.compose.material

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import app.meatin.ui.theme.DarkFlamingo
import app.meatin.ui.theme.Typography
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@ExperimentalCoilApi
@Composable
fun PostCard(
    imageUri: String,
    profileUri: String,
    mainimageUri: String,
    classes: String,
    hearts: Int,
    chats: Int,
    isHearted: Boolean,
    onClick: () -> Unit,
    username: String,
    date: LocalDateTime,
    content: String,
) {
    Card(
        Modifier
            .requiredHeight(287.dp)
            .requiredWidth(343.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable { onClick() },
        backgroundColor = Color.White,
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            val format = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val str: String = format.format(date)
            Column(Modifier.align(Alignment.TopStart)) {
                Row() {
                    Image(
                        modifier = Modifier
                            .height(55.dp)
                            .width(60.dp),
                        painter = rememberImagePainter(
                            data = profileUri
                        ),
                        contentDescription = null
                    )
                    Column() {
                        Row() {
                            Image(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(18.dp),
                                painter = rememberImagePainter(
                                    data = imageUri
                                ),
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = classes,
                                overflow = TextOverflow.Ellipsis,
                                style = Typography.body2,
                                color = Color(0xffFFA318),
                                maxLines = 1
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = username,
                                overflow = TextOverflow.Ellipsis,
                                style = Typography.body2,
                                maxLines = 1
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = str,
                            overflow = TextOverflow.Ellipsis,
                            style = Typography.caption,
                            maxLines = 1,
                        )
                    }
                }
                Text(
                    text = content,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.body2,
                    maxLines = 1,
                )
                Image(
                    modifier = Modifier
                        .height(170.dp)
                        .width(343.dp),
                    painter = rememberImagePainter(
                        data = mainimageUri
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Row() {
                    val heartIcon = if (isHearted) {
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
                    Text(
                        text = hearts.toString(),
                        style = Typography.body2,
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
                    Text(
                        text = chats.toString(),
                        style = Typography.body2,
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
        imageUri = "https://www.nemopan.com/files/attach/images/166591/207/339/014/e96e99e30becc3f29b8b6a4e1e20c1f8.jpg",
        profileUri = "https://www.nemopan.com/files/attach/images/166591/207/339/014/e96e99e30becc3f29b8b6a4e1e20c1f8.jpg",
        mainimageUri = "https://www.nemopan.com/files/attach/images/166591/207/339/014/e96e99e30becc3f29b8b6a4e1e20c1f8.jpg",
        classes = "유사 백선생",
        hearts = 40,
        chats = 50,
        isHearted = true,
        onClick = {},
        username = "김응애",
        date = LocalDateTime.of(1900, 1, 2 ,1,0, 0),
        content = "응애",
    )
}