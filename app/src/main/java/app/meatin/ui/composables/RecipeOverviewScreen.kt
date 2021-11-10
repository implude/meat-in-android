package app.meatin.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import app.meatin.domain.model.FakeValues
import app.meatin.domain.model.Recipe
import app.meatin.ui.composables.components.IngredientItem
import app.meatin.ui.composables.components.PostCard
import app.meatin.ui.composables.components.ProfileButton
import app.meatin.ui.composables.components.RecipeBriefItem
import app.meatin.ui.theme.DisableLightGray2
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import app.meatin.util.defaultDateFormatter
import app.meatin.util.toDate
import coil.compose.rememberImagePainter

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeOverviewScreen(
    recipe: Recipe,
    onProfileButtonClick: () -> Unit,
) {
    LazyColumn(Modifier.background(DisableLightGray2)) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                painter = rememberImagePainter(data = recipe.thumbnail),
                contentDescription = "Recipe overview image",
                contentScale = ContentScale.Crop,
            )

            ConstraintLayout(Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth()) {
                val (
                    titleText,
                    dateText,
                    shareIcon,
                    descriptionText,
                    profileButton,
                    additionalInfoRow,
                ) = createRefs()
                CoreText(
                    modifier = Modifier.constrainAs(titleText) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                    text = recipe.name, style = MeatInTypography.sectionHeader
                )
                CoreText(
                    modifier = Modifier.constrainAs(dateText) {
                        bottom.linkTo(titleText.bottom)
                        start.linkTo(titleText.end, 8.dp)
                    },
                    text = defaultDateFormatter.format(recipe.createdAt.toDate()),
                    style = MeatInTypography.description
                )
                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .constrainAs(shareIcon) {
                            top.linkTo(titleText.top)
                            bottom.linkTo(titleText.bottom)
                            end.linkTo(parent.end)
                        },
                    imageVector = Icons.Default.Share, tint = Color.Black,
                    contentDescription = "Share",
                )
                CoreText(
                    modifier = Modifier.constrainAs(descriptionText) {
                        top.linkTo(titleText.bottom, 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                    text = recipe.description, style = MeatInTypography.regular,
                )
                ProfileButton(
                    modifier = Modifier
                        .constrainAs(profileButton) {
                            top.linkTo(descriptionText.bottom, 13.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth(),
                    user = recipe.author, profileUri = recipe.author.profileImage,
                    onClick = onProfileButtonClick,
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(additionalInfoRow) {
                            top.linkTo(profileButton.bottom, 22.dp)
                        }
                ) {
                    VerticalLabel(title = "소요시간", content = recipe.duration.toRegularTime())
                    VerticalLabel(title = "난이도", content = recipe.difficulty.label)
                }
            }
            SectionDivider()
            // todo add youtube webview
            SectionDivider()
            Column(
                Modifier
                    .background(Color.White)
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            ) {
                CoreText(text = "재료", style = MeatInTypography.sectionHeader)
            }
        }
        items(recipe.ingredients.windowed(2, 2, true)) { item ->
            Row(
                Modifier
                    .background(Color.White)
                    .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 0.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                IngredientItem(onClick = { /*TODO*/ }, ingredient = item[0], modifier = Modifier.weight(1f))
                IngredientItem(onClick = { /*TODO*/ }, ingredient = item[1], modifier = Modifier.weight(1f))
            }
        }
        item {
            Spacer(
                Modifier
                    .background(Color.White)
                    .height(8.dp)
                    .fillParentMaxWidth()
            )
            SectionDivider()
        }
        item {
            ConstraintLayout(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                val (headerText, recipeList) = createRefs()

                CoreText(
                    text = "레시피 브리핑", style = MeatInTypography.sectionHeader,
                    modifier = Modifier.constrainAs(headerText) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                )

                Column(
                    modifier = Modifier.constrainAs(recipeList) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(headerText.bottom, 10.dp)
                    },
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    recipe.briefContent.forEachIndexed { index, description ->
                        RecipeBriefItem(
                            index = index + 1, description = description,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
        item {
            SectionDivider()
            CoreText(
                modifier = Modifier
                    .background(Color.White)
                    .padding(top = 16.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                text = "연결된 포스트", style = MeatInTypography.sectionHeader
            )
        }
        items(recipe.linkedPosts) { post ->
            PostCard(
                post = post, onClick = { /* TODO */ },
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            )
            SectionDivider()
        }
    }
}

@Composable
fun SectionDivider() {
    Spacer(modifier = Modifier.height(8.dp))
}

private fun Int.toRegularTime(): String {
    val hours = this / 3600
    val minutes = this / 60 % 60
    val seconds = this % 60

    return when {
        hours == 0 && minutes == 0 -> "${seconds}초"
        hours == 0 -> "${minutes}분"
        minutes == 0 -> "${hours}시간"
        else -> "${hours}시간 ${minutes}분"
    }
}

@Composable
private fun VerticalLabel(title: String, content: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CoreText(text = title, style = MeatInTypography.description)
        CoreText(text = content, style = MeatInTypography.regularImportant)
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun RecipeOverviewScreenPreview() {
    RecipeOverviewScreen(recipe = FakeValues.RECIPE, onProfileButtonClick = {})
}