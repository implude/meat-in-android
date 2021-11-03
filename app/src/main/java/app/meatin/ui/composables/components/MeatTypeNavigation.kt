package app.meatin.ui.composables.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.meatin.R
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText

@Composable
fun MeatTypeNavigation(
    modifier: Modifier = Modifier,
    meatTypeList: List<String>,
    onClick: () -> Unit,
) {
    BoxWithConstraints(modifier) {
        val maxSize by remember { mutableStateOf(this.maxWidth) }
        Column{
            val selectMeatType = remember { mutableStateOf(meatTypeList[0]) }
            Row(
                Modifier.fillMaxWidth(),
            ) {
                for (meatType in meatTypeList) {
                    CoreText(
                        text = meatType,
                        Modifier
                            .selectable(
                                selected = selectMeatType.value == meatType,
                                role = Role.RadioButton,
                                enabled = true,
                                onClick = {
                                    selectMeatType.value = meatType
                                    onClick()
                                }
                            )
                            .weight(1f),
                        color =
                        if (selectMeatType.value == meatType) {
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
                targetValue = maxSize * meatTypeList.indexOf(selectMeatType.value) / meatTypeList.size,
                spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                ),
            )
            Box(
                Modifier
                    .absoluteOffset(barAnimation)
                    .width(width = maxSize / meatTypeList.size)
                    .height(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_meat_type_bar),
                    contentDescription = null,
                    Modifier.align(Alignment.Center),
                )
            }
        }
    }
}

@Composable
@Preview
fun MeatTypeNavigationPreview() {
    MeatTypeNavigation(
        meatTypeList = listOf("모든고기", "소고기", "돼지고기", "닭고기", "간편식"),
        onClick = {}
    )
}
