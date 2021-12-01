package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.R
import app.meatin.domain.model.AdvertisementModel
import app.meatin.domain.model.BriefRecipe
import app.meatin.domain.model.FakeValues
import app.meatin.domain.model.Post
import app.meatin.ui.composables.components.Advertisement
import app.meatin.ui.composables.components.MeatTypeNavigation
import app.meatin.ui.composables.components.PostCard
import app.meatin.ui.composables.components.RecipeCard
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import java.net.URI

@ExperimentalCoilApi
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navIndex: Int,
    advertisementModel: AdvertisementModel,
    recipes: List<BriefRecipe>,
    posts: List<Post>
) {
    Scaffold(
        content = {
            Column(
                modifier
                    .background(color = Color(0xFFE5E5E5))
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 50.dp)
            ) {
                ConstraintLayout(
                    modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    val (
                        logo,
                        meatTypeNavigation,
                        advertisement
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
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(meatTypeNavigation.bottom, 22.dp)
                            bottom.linkTo(parent.bottom, 14.dp)
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
                        popular
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
                            start.linkTo(parent.start, margin = 16.dp)
                            top.linkTo(popular.bottom, margin = 12.dp)
                            bottom.linkTo(parent.bottom, margin = 16.dp)
                        }
                    ) {
                        items(recipes.size) { count ->
                            RecipeCard(recipe = recipes[count], onClick = {})
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
                        PostCard(
                            post = post,
                            onClick = {},
                            modifier = Modifier.constrainAs(popularPost) {
                                start.linkTo(parent.start, 16.dp)
                                top.linkTo(parent.top, 16.dp)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    )
}

@ExperimentalCoilApi
@Preview
@Composable
fun MainScreenPreview() {

    MainScreen(
        navIndex = 0,
        advertisementModel = FakeValues.ADVERTISEMENT,
        recipes = listOf(FakeValues.BRIEF_RECIPE,FakeValues.BRIEF_RECIPE,FakeValues.BRIEF_RECIPE,FakeValues.BRIEF_RECIPE),
        posts = listOf(FakeValues.POST, FakeValues.POST, FakeValues.POST)
    )
}
