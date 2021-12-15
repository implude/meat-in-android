package app.meatin.ui.composables

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import app.meatin.R
import app.meatin.domain.model.BriefPost
import app.meatin.domain.model.FakeValues
import app.meatin.domain.model.Heart
import app.meatin.domain.model.Ingredient
import app.meatin.domain.model.Recipe
import app.meatin.ui.composables.components.IngredientItem
import app.meatin.ui.composables.components.PostPreviewCard
import app.meatin.ui.composables.components.ProfileButton
import app.meatin.ui.composables.components.RecipeBriefItem
import app.meatin.ui.theme.DisableLightGray2
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import app.meatin.util.defaultDateFormatter
import app.meatin.util.toDate
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun RecipeOverviewScreen(
    recipe: Recipe,
    navController: NavController,
    onProfileButtonClick: () -> Unit,
    onCookButtonClicked: () -> Unit,
    onHeartChanged: (Heart) -> Unit,
) {
    Scaffold(
        content = { Content(recipe, navController, onProfileButtonClick) },
        bottomBar = {
            BottomBar(
                heart = recipe.heart ?: FakeValues.HEARTED_FALSE,
                onHeartChanged = onHeartChanged,
                onCookButtonClicked = onCookButtonClicked
            )
        }
    )
}

private fun Heart.toggle() = Heart(if (hearted) count - 1 else count + 1, !hearted)

@Composable
private fun BottomBar(
    heart: Heart,
    onHeartChanged: (Heart) -> Unit,
    onCookButtonClicked: () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) = Row(
    Modifier
        .clickable(interactionSource = interactionSource, indication = null) { /* Prevent click pass-through */ }
        .background(Color.White)
        .padding(horizontal = 22.dp, vertical = 12.dp)
        .fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(22.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    val interactionSource1 = remember { MutableInteractionSource() }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(
            interactionSource = interactionSource1,
            indication = null,
        ) { onHeartChanged(heart.toggle()) },
    ) {
        val heartIcon = if (heart.hearted) {
            painterResource(id = R.drawable.ic_heart2_filled)
        } else {
            painterResource(id = R.drawable.ic_heart2)
        }

        Icon(
            modifier = Modifier.size(24.dp),
            painter = heartIcon, contentDescription = if (heart.hearted) "Hearted" else "Not hearted",
            tint = Flamingo,
        )
        CoreText(
            text = heart.count.toString(),
            style = MeatInTypography.regular.copy(fontSize = 14.sp),
            color = Flamingo
        )
    }
    Button(
        modifier = Modifier
            .weight(1f)
            .height(56.dp),
        onClick = onCookButtonClicked,
        colors = ButtonDefaults.buttonColors(backgroundColor = Flamingo, contentColor = Color.White),
    ) {
        Icon(
            modifier = Modifier.size(22.dp),
            painter = painterResource(id = R.drawable.ic_cook), contentDescription = "Cook",
        )
        Spacer(Modifier.width(8.dp))
        CoreText(
            text = "이 레시피로 고기 굽기",
            style = MeatInTypography.regularImportant.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            ),
            color = Color.White,
        )
    }
}

@ExperimentalCoilApi
@Composable
private fun Content(
    recipe: Recipe,
    navController: NavController,
    onProfileButtonClick: () -> Unit,
) {
    LazyColumn(Modifier.background(DisableLightGray2)) {
        item {
            ThumbnailImage(recipe.thumbnail)
            Header(recipe, onProfileButtonClick)
            SectionDivider()
            YoutubeDisplay(recipe.youtube)
            SectionDivider()
            IngredientHeader()
        }
        listIngredients(recipe.ingredients)
        item {
            Spacer(
                Modifier
                    .background(Color.White)
                    .height(8.dp)
                    .fillParentMaxWidth()
            )
            SectionDivider()
            RecipeSteps(recipe.briefContent)
            SectionDivider()
            PostHeader()
        }
        listPosts(navController, recipe.linkedPosts)
        item {
            Spacer(Modifier.height(80.dp))
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun ThumbnailImage(thumbnailUri: String) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        painter = rememberImagePainter(data = thumbnailUri),
        contentDescription = "Recipe overview image",
        contentScale = ContentScale.Crop,
    )
}

private fun LazyListScope.listPosts(navController: NavController, linkedPosts: List<BriefPost>) {
    items(linkedPosts) { post ->
        PostPreviewCard(
            post = post,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .clickable { navController.navigate("post_detail/${post.id}") }
                .padding(16.dp)
        )
        SectionDivider()
    }
}

@Composable
private fun PostHeader() {
    CoreText(
        modifier = Modifier
            .background(Color.White)
            .padding(top = 16.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        text = "연결된 포스트", style = MeatInTypography.sectionHeader
    )
}

@Composable
private fun RecipeSteps(recipeSteps: List<String>) {
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
            recipeSteps.forEachIndexed { index, description ->
                RecipeBriefItem(
                    index = index + 1, description = description,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

private fun LazyListScope.listIngredients(ingredients: List<Ingredient>) {
    items(ingredients.windowed(2, 2, true)) { item ->
        Row(
            Modifier
                .background(Color.White)
                .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item.forEach {
                IngredientItem(onClick = { /*TODO*/ }, ingredient = it, modifier = Modifier.weight(0.5f))
            }
            if (item.size < 2) {
                Spacer(
                    Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                )
            }
        }
    }
}

@Composable
private fun IngredientHeader() {
    Column(
        Modifier
            .background(Color.White)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ) {
        CoreText(text = "재료", style = MeatInTypography.sectionHeader)
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
private fun YoutubeDisplay(youtubeUri: String) {
    BoxWithConstraints(
        Modifier
            .background(Color.White)
            .padding(16.dp)
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        if (!youtubeUri.matches("""^[0-9A-Za-z_-]{11}$""".toRegex())) {
            CoreText(text = "유튜브 링크가 손상되어 영상을 표시할 수 없습니다.")
            return@BoxWithConstraints
        }

        val width = with(LocalDensity.current) {
            maxWidth.value
        }
        val height = width * 9 / 16

        AndroidView(
            factory = { context ->
                val frameVideo = "<html><style>body {margin: 0}</style><body><iframe width=\"$width\" " +
                    "height=\"$height\" src=\"https://www.youtube.com/embed/$youtubeUri\" frameborder=\"0\" " +
                    "allowfullscreen></iframe></body></html>"

                WebView(context).apply {
                    this.webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
                            return if (url != null && url.startsWith("https://")) {
                                view.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                                true
                            } else {
                                false
                            }
                        }
                    }
                    this.webChromeClient = WebChromeClient()
                    val webSettings = this.settings
                    webSettings.javaScriptEnabled = true
                    this.loadData(frameVideo, "text/html", "utf-8")
                    this.minimumWidth = width.toInt()
                    this.minimumHeight = height.toInt()
                    this.loadUrl(frameVideo)
                }
            }
        )
    }
}

@ExperimentalCoilApi
@Composable
private fun Header(recipe: Recipe, onProfileButtonClick: () -> Unit) {
    ConstraintLayout(
        Modifier
            .background(Color.White)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
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
                .shadow(1.dp, RoundedCornerShape(5.dp))
                .constrainAs(profileButton) {
                    top.linkTo(descriptionText.bottom, 13.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            user = recipe.author, profileUri = recipe.author.profileImage ?: "",
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
            VerticalLabel(title = "소요시간", content = recipe.duration.formatAsTime())
            VerticalLabel(title = "난이도", content = recipe.difficulty.label)
        }
    }
}

@Composable
private fun SectionDivider() {
    Spacer(modifier = Modifier.height(8.dp))
}

private fun Int.formatAsTime(): String {
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

// @Preview(showBackground = true, backgroundColor = 0xffffffff, heightDp = 1300)
// @Composable
// fun RecipeOverviewScreenPreview() {
//     val (heart, setHeart) = remember { mutableStateOf(Heart(124, false)) }
//     RecipeOverviewScreen(
//         recipe = FakeValues.RECIPE.copy(heart = heart),
//         onProfileButtonClick = {},
//         onHeartChanged = setHeart,
//         onCookButtonClicked = {},
//     )
// }

// @Preview
// @Composable
// fun BottomBarPreview() {
//     val (heart, setHeart) = remember { mutableStateOf(Heart(124, false)) }
//     BottomBar(heart, setHeart, {})
// }
