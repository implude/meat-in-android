package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import app.meatin.R
import app.meatin.domain.model.AdvertisementModel
import app.meatin.domain.model.BriefPost
import app.meatin.domain.model.BriefRecipe
import app.meatin.ui.composables.components.Advertisement
import app.meatin.ui.composables.components.MeatTypeNavigation
import app.meatin.ui.composables.components.PostPreviewCard
import app.meatin.ui.composables.components.RecipeCard
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import java.net.URI

@ExperimentalCoilApi
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    navIndex: Int,
    advertisementModel: AdvertisementModel,
    recipes: List<BriefRecipe>,
    posts: List<BriefPost>,
) {
    Scaffold(
        content = {
            Column(
                modifier
                    .background(color = Color(0xFFE5E5E5))
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                ConstraintLayout(
                    modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    val (
                        logo,
                        meatTypeNavigation,
                        advertisement,
                    ) = createRefs()

                    Image(
                        modifier = Modifier.constrainAs(logo) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(parent.top, 11.dp)
                        },
                        painter = painterResource(R.drawable.ic_logo),
                        contentDescription = null
                    )
                    var meatTypeIndex by remember { mutableStateOf(navIndex) }
                    MeatTypeNavigation(
                        meatTypeList = listOf("모든고기", "소고기", "돼지고기", "닭고기", "간편식"),
                        onClick = { meatTypeIndex = it },
                        meatTypeIndex = meatTypeIndex,
                        modifier = Modifier.constrainAs(meatTypeNavigation) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(logo.bottom, 34.dp)
                        }
                    )
                    Advertisement(
                        title = advertisementModel.title,
                        subtitle = advertisementModel.subtitle,
                        imageUri = URI(advertisementModel.imageUri),
                        modifier = Modifier.constrainAs(advertisement) {
                            start.linkTo(parent.start, 16.dp)
                            end.linkTo(parent.end, 16.dp)
                            top.linkTo(meatTypeNavigation.bottom, 22.dp)
                            bottom.linkTo(parent.bottom, 14.dp)

                            width = Dimension.fillToConstraints
                        },
                        onClick = {}
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                ConstraintLayout(
                    modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    val (
                        recipeCards,
                        popular,
                    ) = createRefs()
                    CoreText(
                        modifier = Modifier.constrainAs(popular) {
                            start.linkTo(parent.start, 16.dp)
                            top.linkTo(parent.top, 16.dp)
                        },
                        text = "인기 레시피",
                        style = MeatInTypography.sectionHeader
                    )
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.constrainAs(recipeCards) {
                            start.linkTo(parent.start)
                            top.linkTo(popular.bottom, margin = 12.dp)
                            bottom.linkTo(parent.bottom, margin = 16.dp)
                        }
                    ) {
                        items(recipes.size) { count ->
                            if (count == 0) {
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                            RecipeCard(
                                recipe = recipes[count],
                                onClick = {
                                    navController.navigate("recipe_overview/${recipes[count].id}")
                                }
                            )
                            if (count == recipes.size - 1) {
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                ConstraintLayout(
                    modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    val popularPostTitle = createRef()
                    CoreText(
                        text = "실시간 인기 포스트",
                        modifier = Modifier.constrainAs(popularPostTitle) {
                            start.linkTo(parent.start, 16.dp)
                            top.linkTo(parent.top, 16.dp)
                        },
                        style = MeatInTypography.sectionHeader
                    )
                }
                posts.forEach { post ->
                    ConstraintLayout(
                        modifier
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        val popularPost = createRef()
                        PostPreviewCard(
                            post = post,
                            modifier = Modifier
                                .constrainAs(popularPost) {
                                    start.linkTo(parent.start)
                                    top.linkTo(parent.top)
                                }
                                .clickable {
                                    navController.navigate("post_detail/${post.id}")
                                }
                                .padding(16.dp)
                                .fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(64.dp)
                        .background(Flamingo)
                ) {
                    Image(
                        modifier = Modifier.align(alignment = Alignment.Center),
                        painter = painterResource(id = R.drawable.ic_fire),
                        contentDescription = null,
                    )
                }
            }
        }
    )
}

// @ExperimentalCoilApi
// @Preview
// @Composable
// fun MainScreenPreview() {
//     MainScreen(
//         navIndex = 0,
//         advertisementModel = FakeValues.ADVERTISEMENT,
//         recipes = listOf(
//             FakeValues.BRIEF_RECIPE,
//             FakeValues.BRIEF_RECIPE,
//             FakeValues.BRIEF_RECIPE,
//             FakeValues.BRIEF_RECIPE,
//         ),
//         posts = listOf(
//             FakeValues.BRIEF_POST,
//             FakeValues.BRIEF_POST,
//             FakeValues.BRIEF_POST,
//         )
//     )
// }
