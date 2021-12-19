package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.meatin.domain.model.Recipe
import app.meatin.domain.model.RecipeDisplayable
import app.meatin.domain.model.RecipeStep
import app.meatin.ui.composables.components.Timer
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import app.meatin.domain.model.Timer as TimerModel

@ExperimentalCoilApi
@Composable
fun InnerRecipeStepScreen(
    modifier: Modifier = Modifier,
    index: Int,
    recipe: Recipe,
    recipeDisplayableList: List<RecipeDisplayable>,
    onTimerFinished: () -> Unit,
) {

    val onlyRecipeSteps = recipeDisplayableList.filterIsInstance(RecipeStep::class.java)
    if (index == 0) {
        TitleView(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            recipe = recipe
        )
    } else when (val currentDisplayable = recipeDisplayableList[index - 1]) {
        is RecipeStep -> RecipeStepView(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            index = onlyRecipeSteps.indexOf(currentDisplayable) + 1,
            recipeStep = currentDisplayable
        )
        is TimerModel -> TimerView(
            millisecond = currentDisplayable.duration,
            onRemainingTimeChange = { if (it == 0L) onTimerFinished() }
        )
    }
}

@ExperimentalCoilApi
@Composable
private fun TitleView(
    modifier: Modifier = Modifier,
    recipe: Recipe,
) {
    Box(modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            CoreText(
                text = "구워보세요,",
                modifier = Modifier.padding(bottom = 3.dp),
                style = MeatInTypography.sectionHeader,
            )
            CoreText(
                text = recipe.name,
                style = MeatInTypography.pageTitle,
            )
            Image(
                modifier = Modifier
                    .padding(top = 17.dp, bottom = 16.dp)
                    .height(220.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp)),
                painter = rememberImagePainter(
                    data = recipe.thumbnail,
                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            CoreText(
                text = recipe.description,
                style = MeatInTypography.sectionHeader,
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
private fun RecipeStepView(
    modifier: Modifier = Modifier,
    index: Int,
    recipeStep: RecipeStep,
) {
    val split = recipeStep.title.split(" 번째, ")

    val (intro, subtitle) = if (split.size <= 1) {
        "${getHangulCount(index)} 번째," to recipeStep.title
    } else {
        "${split[0]} 번째," to split[1]
    }

    val image = recipeStep.image

    val content = recipeStep.content

    Box(modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            CoreText(
                text = intro,
                modifier = Modifier.padding(bottom = 3.dp),
                style = MeatInTypography.sectionHeader,
            )
            CoreText(
                text = subtitle,
                style = MeatInTypography.pageTitle,
            )
            Image(
                modifier = Modifier
                    .padding(top = 17.dp, bottom = 16.dp)
                    .height(220.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp)),
                painter = rememberImagePainter(
                    data = image,
                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            CoreText(
                text = content,
                style = MeatInTypography.sectionHeader,
            )
        }
    }
}

fun getHangulCount(index: Int): String {
    return listOf("", "첫", "두", "세", "네", "다섯", "여섯", "일곱", "여덟", "아홉", "열")[index]
}

@Composable
private fun TimerView(
    millisecond: Long,
    onRemainingTimeChange: (Long) -> Unit,
) {
    Box(
        modifier = Modifier
            .background(Flamingo)
            .fillMaxSize()
    ) {
        Timer(millisecond = millisecond, onRemainingTimeChange = onRemainingTimeChange)
        CoreText(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            text = "스킵", color = Color.White, style = MeatInTypography.subHeader,
            onClick = {
                onRemainingTimeChange(0)
            }
        )
    }
}
