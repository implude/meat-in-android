package app.meatin.ui.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import app.meatin.domain.model.FakeValues
import app.meatin.domain.model.Ingredient
import app.meatin.ui.theme.DarkFlamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText

@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    ingredient: Ingredient,
) {
    val essentialText = if (ingredient.required) {
        "필수"
    } else {
        "선택"
    }

    val essentialColor = if (ingredient.required) {
        DarkFlamingo
    } else {
        Color.Gray
    }

    ConstraintLayout(
        modifier
            .height(130.dp)
            .border(2.dp, Color.Black.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(6.dp))
            .clickable { onClick() }
            .background(Color.White)
    ) {
        val (
            nameText,
            quantityRow,
            essentialsText,
            descriptionText,
        ) = createRefs()

        CoreText(
            modifier = Modifier.constrainAs(nameText) {
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end, 16.dp)
                top.linkTo(parent.top, 12.dp)
                width = Dimension.fillToConstraints
            },
            text = ingredient.label,
            overflow = TextOverflow.Ellipsis,
            style = MeatInTypography.regularImportant,
            maxLines = 2
        )
        Row(
            modifier = Modifier
                .constrainAs(quantityRow) {
                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(nameText.bottom, 1.dp)
                    end.linkTo(essentialsText.start)
                    width = Dimension.fillToConstraints
                }
        ) {
            CoreText(
                text = ingredient.amount,
                overflow = TextOverflow.Ellipsis,
                style = MeatInTypography.regular,
                maxLines = 1
            )
        }
        CoreText(
            modifier = Modifier
                .constrainAs(essentialsText) {
                    top.linkTo(quantityRow.top)
                    end.linkTo(parent.end, 16.dp)
                },
            text = essentialText,
            overflow = TextOverflow.Ellipsis,
            style = MeatInTypography.regularImportant,
            color = essentialColor,
            maxLines = 1
        )

        CoreText(
            modifier = Modifier
                .constrainAs(descriptionText) {
                    top.linkTo(quantityRow.bottom, 6.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.fillToConstraints
                }
                .height(38.dp),

            text = ingredient.content ?: "",
            overflow = TextOverflow.Ellipsis,
            style = MeatInTypography.regular,
            color = Color.Gray,
            maxLines = 2
        )
    }
}

@Preview
@Composable
fun IngredientItemPreview() {
    IngredientItem(
        modifier = Modifier.width(150.dp),
        ingredient = FakeValues.INGREDIENT,
        onClick = { },
    )
}
