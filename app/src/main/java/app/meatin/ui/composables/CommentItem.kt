package app.meatin.ui.composables

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

@Composable
fun CommentItem(
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
                text = date,
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

@Preview(showBackground = true)
@Composable
fun CommentItemPreview() {
    CommentItem(
        writer = "박정한",
        date = "2021년 08년 34일",
        content = "정말 맛있어보이네요,,^^ 저도  .. 아가들한테 해주야겠어요..^^,,"
    )
}
