package app.meatin.ui.composables.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.ui.theme.BorderGray
import app.meatin.ui.theme.DisableLightGray2
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi

@SuppressLint("UnrememberedMutableState")
@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun View() {
    var selectedMeatType: MeatType? by remember { mutableStateOf(MeatType.values()[0]) }
    ChipGroup(
        value = getAllMeatTypes(),
        selectedValue = selectedMeatType,
        onSelectedChanged = {
            Log.d("select", it)
            selectedMeatType = getMeatType(it)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun Chip(
    name: String = "돼지고기",
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {},
) {
    Surface(
        modifier = Modifier.padding(6.dp),
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) Flamingo else DisableLightGray2
    ) {
        Row(
            modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                }
            )
        ) {
            CoreText(
                text = name,
                style = MeatInTypography.regular,
                color = if (isSelected) Color.White else BorderGray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChipGroup(
    value: List<MeatType> = getAllMeatTypes(),
    selectedValue: MeatType? = null,
    onSelectedChanged: (String) -> Unit = {},
) {
    Column(modifier = Modifier.padding(8.dp)) {
        LazyRow {
            items(value) {
                Chip(
                    name = it.value,
                    isSelected = selectedValue == it,
                    onSelectionChanged = { it1 ->
                        onSelectedChanged(it1)
                    },
                )
            }
        }
    }
}

enum class MeatType(val value: String) {
    Pork("돼지고기"),
    Beef("소고기"),
    Chicken("닭고기"),
    Processed("가공육류")
}

enum class Env(val value: String) {
    Pan("후라이펜"),
    Direct("직화"),
    Charcoal("숯불"),
    AirFri("에어프라이기")
}

fun getAllMeatTypes(): List<MeatType> {
    return listOf(MeatType.Pork, MeatType.Beef, MeatType.Chicken, MeatType.Processed)
}

fun getMeatType(value: String): MeatType? {
    val map = MeatType.values().associateBy(MeatType::value)
    return map[value]
}
