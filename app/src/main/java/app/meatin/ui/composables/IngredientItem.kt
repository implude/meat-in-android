package app.meatin.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.ui.theme.CoreText
import app.meatin.ui.theme.DarkFlamingo
import app.meatin.ui.theme.MeatInTypography
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    name: String,
    quantity: Number,
    unit: String,
    isEssential: Boolean,
    description: String,
) {
    val essentialText = if (isEssential) {
        "필수"
    } else {
        "선택"
    }

    val essentialColor = if (isEssential) {
        DarkFlamingo
    } else {
        Color.Gray
    }

    ConstraintLayout(
        modifier
            .size(167.dp, 130.dp)
            .clip(RoundedCornerShape(6.dp))
            .clickable { onClick() }
            .background(Color.White)
            .border(1.dp, Color.Gray, RoundedCornerShape(6.dp))
    ) {
        val (
            nameText,
            quantityRow,
            essentialsText,
            descriptionText,
        ) = createRefs()

        CoreText(
            modifier = Modifier
                .constrainAs(nameText) {
                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(parent.top, 12.dp)
                },
            text = name,
            overflow = TextOverflow.Ellipsis,
            style = MeatInTypography.regularImportant,
            maxLines = 1
        )
        Row(
            modifier = Modifier
                .constrainAs(quantityRow) {
                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(nameText.bottom, 1.dp)
                },
        ){
            CoreText(
                text = quantity.toString(),
                overflow = TextOverflow.Ellipsis,
                style = MeatInTypography.regular,
                maxLines = 1
            )

            CoreText(
                text = unit,
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
                }
                .width(134.dp)
                .height(38.dp),

            text = description,
            overflow = TextOverflow.Ellipsis,
            style = MeatInTypography.regular,
            color = Color.Gray,
            maxLines = 3
        )
    }
}
//        Box(
//            Modifier
//                .fillMaxSize()
//                .padding(horizontal = 16.dp, vertical = 12.dp)
//        ) {
//            Column(
//                Modifier
//                    .align(Alignment.TopStart)
//            ) {
//                CoreText(
//                    text = name,
//                    overflow = TextOverflow.Ellipsis,
//                    style = MeatInTypography.regularImportant,
//                    maxLines = 1
//                )
//                Row{
//                    Row(
//                    ) {
//                        CoreText(
//                            text = quantity.toString(),
//                            overflow = TextOverflow.Ellipsis,
//                            style = MeatInTypography.regular,
//                            maxLines = 1
//                        )
//                        CoreText(
//                            text = unit,
//                            overflow = TextOverflow.Ellipsis,
//                            style = MeatInTypography.regular,
//                            maxLines = 1
//                        )
//                    }
//                    Column(
//                        horizontalAlignment = Alignment.End,
//                    ) {
//                        val essentialText = if (isEssential) {
//                            "필수"
//                        } else {
//                            "선택"
//                        }
//                        val essentialColor = if (isEssential) {
//                            DarkFlamingo
//                        } else {
//                            Color.Gray
//                        }
//                        CoreText(
//                            text = essentialText,
//                            overflow = TextOverflow.Ellipsis,
//                            style = MeatInTypography.regularImportant,
//                            color = essentialColor,
//                            maxLines = 1
//                        )
//                    }
//                }
//                Spacer(modifier = Modifier.height(6.dp))
//                CoreText(
//                    text = description,
//                    overflow = TextOverflow.Ellipsis,
//                    style = MeatInTypography.regular,
//                    color = Color.Gray,
//                    maxLines = 2
//                )
//            }
//        }

@Preview
@Composable
fun IngredientItemPreview() {
    IngredientItem(
        Modifier.padding(10.dp),
        onClick = {},
        name = "아스파라거스",
        quantity = 10,
        unit = "모",
        isEssential = true,
        description = "메인재료래요. 간단한 설명을 넣어요."
    )
}
