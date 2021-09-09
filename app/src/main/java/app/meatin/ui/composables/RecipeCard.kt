package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
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
import app.meatin.ui.theme.DisableLightGray2
import app.meatin.ui.theme.Typography
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
    isHearted: Boolean,
    onClick: () -> Unit,
) {
    Card(
        modifier
            .requiredSize(160.dp, 163.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable { onClick() },
        backgroundColor = Color.White,
    ) {
        Column {

            Image(
                modifier = Modifier
                    .height(72.dp)
                    .background(DisableLightGray2),
                painter = rememberImagePainter(
                    data = imageUri.toASCIIString()
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            Box(
                Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                Column(Modifier.align(Alignment.TopStart)) {
                    Text(
                        text = title,
                        overflow = TextOverflow.Ellipsis,
                        style = Typography.body1,
                        maxLines = 1,
                    )
                    Text(
                        text = subtitle,
                        overflow = TextOverflow.Ellipsis,
                        style = Typography.caption,
                        maxLines = 2,
                    )
                }

                Row(
                    Modifier.align(Alignment.BottomStart),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
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
        hearts = 777,
        isHearted = true,
        onClick = {},
    )
}

@ExperimentalCoilApi
@Preview
@Composable
fun RecipeCardPreviewSingleLine() {
    RecipeCard(
        Modifier.padding(10.dp),
        title = "나이아가라 폭포",
        subtitle = "집에서도 시원한",
        imageUri = URI("https://ychef.files.bbci.co.uk/976x549/p04kt0s1.jpg"),
        hearts = 777,
        isHearted = false,
        onClick = {},
    )
}

@ExperimentalCoilApi
@Preview
@Composable
fun RecipeCardPreviewOverTwoLines() {
    RecipeCard(
        Modifier.padding(10.dp),
        title = "나이아가라 폭포",
        subtitle = "집에서도 시원한 나이아가라 폭포를 즐겨보세요. 여름을 이겨내는 최고의 방법을 알려드립니다.",
        imageUri = URI("https://ychef.files.bbci.co.uk/976x549/p04kt0s1.jpg"),
        hearts = 777,
        isHearted = false,
        onClick = {},
    )
}