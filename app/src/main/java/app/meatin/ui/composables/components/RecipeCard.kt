package app.meatin.ui.composables.components

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
import app.meatin.domain.model.BriefRecipe
import app.meatin.domain.model.Difficulty
import app.meatin.domain.model.FakeValues
import app.meatin.domain.model.Heart
import app.meatin.domain.model.MeatType
import app.meatin.ui.theme.DarkFlamingo
import app.meatin.ui.theme.DisableLightGray2
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: BriefRecipe,
//    title: String,
//    subtitle: String,
//    imageUri: URI,
//    hearts: Int,
//    isHearted: Boolean,
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
                    data = recipe.thumbnail,
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
                        text = recipe.name,
                        overflow = TextOverflow.Ellipsis,
                        style = MeatInTypography.regular
                            .copy(fontWeight = FontWeight.SemiBold),
                        maxLines = 1,
                    )
                    CoreText(
                        text = recipe.description,
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
                    val heartIcon = if (recipe.heart.hearted) {
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
                        text = recipe.heart.count.toString(),
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
        modifier = Modifier.padding(10.dp),
        recipe = FakeValues.BRIEF_RECIPE,
        onClick = { },
    )
}
