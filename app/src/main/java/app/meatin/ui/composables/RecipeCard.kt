package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.meatin.ui.theme.CoreText
import app.meatin.ui.theme.DarkFlamingo
import app.meatin.ui.theme.DisableLightGray2
import app.meatin.ui.theme.MeatInTypography
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
            .requiredSize(160.dp, 177.dp)
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
                    CoreText(
                        text = title,
                        overflow = TextOverflow.Ellipsis,
                        style = MeatInTypography.regular
                            .copy(fontWeight = FontWeight.SemiBold),
                        maxLines = 1,
                    )
                    CoreText(
                        text = subtitle,
                        overflow = TextOverflow.Ellipsis,
                        style = MeatInTypography.regular,
                        maxLines = 2,
                        color = Color.Black.copy(alpha = 0.3f)
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
                    CoreText(
                        text = hearts.toString(),
                        style = MeatInTypography.regularImportant.copy(fontSize = 12.sp),
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
