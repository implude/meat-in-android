package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.domain.model.RecipeStep
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun BaroCookScreen(
    index: Int,
    recipeSteps: List<RecipeStep>
) {
    val splitArray = recipeSteps[index].title.split(",")
    val intro = splitArray[0]
    val subtitle = splitArray[1]
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .width(327.dp)
                .align(Alignment.Center)
        ) {
            CoreText(
                text = "$intro,",
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
                    .width(327.dp)
                    .clip(RoundedCornerShape(4.dp)),
                painter = rememberImagePainter(
                    data = recipeSteps[index].image,
                ),
                contentDescription = null,

            )
            CoreText(
                text = recipeSteps[index].content,
                style = MeatInTypography.sectionHeader,
            )
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun BaroCookScreenPreview() {
    var index by remember { mutableStateOf(0) }
    val recipeSteps = listOf(
        RecipeStep(
            "https://www.seriouseats.com/thmb/Q4DbCSfWJfnDqpqA7164YRMTgeY=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__recipes__images__2016__02__20160208-sous-vide-pork-chop-guide-food-lab-37-9bfa2f9b8a464bccad99ea08423b9d8e.jpg",
            "구워보세요,육즙 가득한 삼겹살",
            "코로나 때문에 외식을 자주 못하는 요즘, 고깃집에서 먹는 삼겹살의 맛을 집에서 구워보세요!",
            "",
        ),
        RecipeStep(
            "https://www.seriouseats.com/thmb/Q4DbCSfWJfnDqpqA7164YRMTgeY=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__recipes__images__2016__02__20160208-sous-vide-pork-chop-guide-food-lab-37-9bfa2f9b8a464bccad99ea08423b9d8e.jpg",
            "첫번째,기깔나게 삼겹살 손질하기",
            "생삼겹을 준비한 다음, 키친타올로 핏물을 제거해주세요.",
            "",
        ),
        RecipeStep(
            "https://www.seriouseats.com/thmb/Q4DbCSfWJfnDqpqA7164YRMTgeY=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__recipes__images__2016__02__20160208-sous-vide-pork-chop-guide-food-lab-37-9bfa2f9b8a464bccad99ea08423b9d8e.jpg",
            "두번째,후라이팬 예열하기",
            "강불에서 갈군 후라이펜에 물을 떨궈 물방울이 맺히면 물을 닦고, 후라이펜에 기름을 둘러주세요.",
            "",
        ),
    )
    Box(Modifier.fillMaxSize()) {
        BaroCookScreen(index, recipeSteps)
        Button(
            onClick = {
                index += if (index == recipeSteps.size - 1) {
                    0
                } else {
                    1
                }
            },
            modifier = Modifier
                .padding(top = 40.dp, bottom = 48.dp)
                .width(343.dp)
                .height(55.dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Flamingo
            )
        ) {
            CoreText(
                text = when (index) {
                    0 -> "시작하기"
                    else -> "다음 단계"
                },
                style = MeatInTypography.sectionHeader,
                color = Color.White
            )
        }
    }
}
