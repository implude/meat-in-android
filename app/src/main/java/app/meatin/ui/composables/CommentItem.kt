package app.meatin.ui.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.ui.theme.Typography
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

@Composable
fun CommentItem(
    modifier: Modifier = Modifier,
    writer: String,
    date: String,
    content: String,
) {
    Column {
        Row {
            Text(
                modifier = Modifier
                    .padding(end = 8.dp),
                text = writer,
                overflow = TextOverflow.Ellipsis,
                style = Typography.body1,
                maxLines = 1
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = date.toString(),
                overflow = TextOverflow.Ellipsis,
                style = Typography.caption,
                maxLines = 1
            )
        }
        Text(
            text = content,
            style = Typography.body2
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CommentItemPreview() {
    CommentItem(
        writer = "박정한",
        date = LocalDateTime.of(2022, Month.FEBRUARY, 22, 22, 22, 22)
            .format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")),
        content = "정말 맛있어보이네요,,^^ 저도  .. 아가들한테 해주야겠어요..^^,,"
    )
}
