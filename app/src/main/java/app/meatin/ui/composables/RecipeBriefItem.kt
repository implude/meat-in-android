package app.meatin.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import app.meatin.ui.theme.composefix.CoreText
import app.meatin.ui.theme.MeatInTypography

@Composable
fun RecipeBriefItem(
    index: Int,
    description: String,
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(modifier) {
        val (indexText, descriptionText) = createRefs()

        CoreText(
            text = index.toString(),
            style = MeatInTypography.regularImportant.copy(
                lineHeight = (12 + 24).sp,
                fontSize = 12.sp,
                color = Color.Black.copy(alpha = 0.4f)
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .size(24.dp)
                .border(1.dp, Color.Black.copy(alpha = 0.1f), CircleShape)
                .constrainAs(indexText) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        CoreText(
            text = description,
            modifier = Modifier
                .constrainAs(descriptionText) {
                    start.linkTo(indexText.end, 10.dp)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun RecipeBriefItemPreview() {
    val recipes: List<String> = listOf(
        "후라이팬에 기름을 두르고 연기가 올라올 때까지 중불로 달궈주세요",
        "두부를 손가락 하나 두께로 썰어주세요",
        "양면이 노릇해질 때까지 2분 간격으로 뒤집어주세요",
    )

    ConstraintLayout(
        modifier = Modifier
            .width(375.dp)
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

        LazyColumn(
            modifier = Modifier.constrainAs(recipeList) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(headerText.bottom, 10.dp)
            },
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(recipes) { index, description ->
                RecipeBriefItem(
                    index = index + 1, description = description,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
