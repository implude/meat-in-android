package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.meatin.R
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.net.URI

@ExperimentalCoilApi
@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageUri: URI,
    hearts: Int,
) {
    Card(
        modifier
            .requiredSize(161.dp, 142.dp)
            .clip(RoundedCornerShape(5.dp)),
        backgroundColor = Color.White,
    ) {
        Column {
            Image(
                modifier = Modifier
                    .height(71.dp),
                painter = rememberImagePainter(
                    data = imageUri.toASCIIString()
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            Column(
                Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 7.dp, bottom = 10.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = Color.Black.copy(alpha = 0.4f),
                )
                Row(
                    Modifier.padding(top = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier.padding(end = 2.dp),
                        painter = painterResource(R.drawable.ic_heart),
                        contentDescription = null,
                        tint = Color(0xFFFF5252),
                    )
                    Text(
                        text = hearts.toString(),
                        fontSize = 10.sp,
                        color = Color(0xFFFF5252),
                    )
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun RecipeCardPreview() {
    RecipeCard(
        Modifier.padding(10.dp),
        title = "나이아가라 폭포",
        subtitle = "집에서도 시원한 나이아가라 폭포를 즐겨보세요.",
        imageUri = URI("https://ychef.files.bbci.co.uk/976x549/p04kt0s1.jpg"),
        hearts = 777
    )
}