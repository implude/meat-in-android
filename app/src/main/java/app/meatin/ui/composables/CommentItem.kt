package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import app.meatin.ui.theme.CoreText
import app.meatin.ui.theme.MeatInTypography
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

@ExperimentalCoilApi
@Composable
fun CommentItem(
    modifier: Modifier = Modifier,
    badgeUri: String,
    classes: String,
    classesColor: Color,
    username: String,
    date: LocalDateTime,
    content: String,
) {
    Column(modifier) {
        Row {
            Image(
                modifier = Modifier
                    .height(18.dp)
                    .width(18.dp)
                    .align(Alignment.CenterVertically),
                painter = rememberImagePainter(
                    data = badgeUri
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            CoreText(
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp)
                    .align(Alignment.CenterVertically),
                text = classes,
                overflow = TextOverflow.Ellipsis,
                style = MeatInTypography.regular,
                color = classesColor,
                maxLines = 1
            )
            CoreText(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically),
                text = username,
                overflow = TextOverflow.Ellipsis,
                style = MeatInTypography.regularImportant,
                maxLines = 1
            )
            CoreText(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = date.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")),
                overflow = TextOverflow.Ellipsis,
                style = MeatInTypography.regular,
                color = Color.Black.copy(alpha = 0.3f),
                maxLines = 1
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        CoreText(
            text = content,
            style = MeatInTypography.regular
        )
    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun CommentItemPreview() {
    CommentItem(
        badgeUri = "https://www.nemopan.com/files/attach/images/166591/207/339/014/e96e99e30becc3f29b8b6a4e1e20c1f8.jpg",
        classes = "유사 백선생",
        classesColor = Color(0xffFFA318),
        username = "박정한",
        date = LocalDateTime.of(2022, Month.FEBRUARY, 22, 22, 22, 22),
        content = "정말 맛있어보이네요,,^^ 저도  .. 아가들한테 해주야겠어요..^^,,"
    )
}
