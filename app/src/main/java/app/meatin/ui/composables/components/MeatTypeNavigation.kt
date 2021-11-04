package app.meatin.ui.composables.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText

@Composable
fun MeatTypeNavigation(
    modifier: Modifier = Modifier,
    meatTypeList: List<String>,
    onClick: (Int) -> Unit,
    meatTypeIndex: Int,
) {
    BoxWithConstraints(modifier) {
        val maxSize by remember { mutableStateOf(this.maxWidth) }
        Column {
            Row(
                Modifier.fillMaxWidth(),
            ) {
                meatTypeList.forEachIndexed { index, meatType ->
                    CoreText(
                        text = meatType,
                        Modifier
                            .selectable(
                                selected = meatTypeList[meatTypeIndex] == meatType,
                                role = Role.RadioButton,
                                enabled = true,
                                onClick = {
                                    onClick(index)
                                }
                            )
                            .weight(1f),
                        color = if (meatTypeList[meatTypeIndex] == meatType) {
                            Color(0xFF333333)
                        } else {
                            Color(0xFFD4D4D4)
                        },
                        textAlign = TextAlign.Center,
                        style = MeatInTypography.regularImportant.copy(fontWeight = FontWeight.Bold),
                    )
                }
            }
            val barAnimation: Dp by animateDpAsState(
                targetValue = maxSize * meatTypeIndex / meatTypeList.size,
                spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                ),
            )
            Box(
                Modifier
                    .absoluteOffset(barAnimation)
                    .width(width = maxSize / meatTypeList.size)
                    .height(7.dp)
            ) {
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .clip(RoundedCornerShape(10.dp))
                        .size(20.dp, 3.dp)
                        .background(Flamingo)
                )
            }
        }
    }
}

@Composable
@Preview
fun MeatTypeNavigationPreview() {
    var meatTypeIndex by remember { mutableStateOf(0) }
    MeatTypeNavigation(
        meatTypeIndex = meatTypeIndex,
        meatTypeList = listOf("모든고기", "소고기", "돼지고기", "닭고기", "간편식"),
        onClick = { meatTypeIndex = it }
    )
}
