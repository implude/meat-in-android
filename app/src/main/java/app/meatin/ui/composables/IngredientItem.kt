package app.meatin.ui.composables

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.ui.theme.DarkFlamingo
import app.meatin.ui.theme.MeatInTypography

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
    Card(
        modifier
            .height(88.dp)
            .width(167.dp)
            .clip(RoundedCornerShape(6.dp))
            .clickable { onClick() }
            .border(1.dp, Color.Gray, RoundedCornerShape(6.dp)),
        backgroundColor = Color.White,
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Column(
                Modifier
                    .align(Alignment.TopStart)
            ) {
                Row {
                    Row(
                        Modifier.width(50.dp)
                    ) {
                        Text(
                            text = name,
                            overflow = TextOverflow.Ellipsis,
                            style = MeatInTypography.regularImportant,
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = quantity.toString(),
                            overflow = TextOverflow.Ellipsis,
                            style = MeatInTypography.regular,
                            maxLines = 1
                        )
                        Text(
                            text = unit,
                            overflow = TextOverflow.Ellipsis,
                            style = MeatInTypography.regular,
                            maxLines = 1
                        )
                    }
                    Column(
                        modifier = Modifier
                            .width(90.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.End,
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
                        Text(
                            text = essentialText,
                            overflow = TextOverflow.Ellipsis,
                            style = MeatInTypography.regularImportant,
                            color = essentialColor,
                            maxLines = 1
                        )
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = description,
                    overflow = TextOverflow.Ellipsis,
                    style = MeatInTypography.regular,
                    color = Color.Gray,
                    maxLines = 2
                )
            }
        }
    }
}

@Preview
@Composable
fun IngredientItemPreview() {
    IngredientItem(
        Modifier.padding(10.dp),
        onClick = {},
        name = "두부",
        quantity = 2,
        unit = "모" ,
        isEssential = true,
        description = "메인재료래요. 간단한 설명을 넣어요."
    )
}
