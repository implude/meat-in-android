package app.meatin.ui.composables.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.domain.model.BriefBadge
import app.meatin.domain.model.BriefCommunityUser
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

@ExperimentalCoilApi
@Composable
fun CommentItem(
    modifier: Modifier = Modifier,
    user: BriefCommunityUser,
    date: LocalDateTime,
    content: String,
) {
    Column(modifier) {
        Row {
            BadgedUser(modifier = Modifier.padding(end = 8.dp), user = user)
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
        user = BriefCommunityUser(
            name = "김응애", profileImage = "sample uri",
            repBadge = BriefBadge("sample uri", "유사 백선생")
        ),
        date = LocalDateTime.of(2022, Month.FEBRUARY, 22, 22, 22, 22),
        content = "정말 맛있어보이네요,,^^ 저도  .. 아가들한테 해주야겠어요..^^,,"
    )
}
