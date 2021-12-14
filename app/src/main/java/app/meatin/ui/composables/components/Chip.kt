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
    var selectedMeatType: String? by remember { mutableStateOf(allMeatType[0]) }
    ChipGroup(
        value = allEnvType,
        selectedValue = selectedMeatType,
        onSelectedChanged = {
            Log.d("select", it)
            selectedMeatType = it
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
            modifier = Modifier.toggleable(
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
    value: List<String> = allMeatType,
    selectedValue: String? = null,
    onSelectedChanged: (String) -> Unit = {},
) {
    Column(modifier = Modifier.padding(8.dp)) {
        LazyRow {
            items(value) {
                Chip(
                    name = it,
                    isSelected = selectedValue == it,
                    onSelectionChanged = { it1 ->
                        onSelectedChanged(it1)
                    },
                )
            }
        }
    }
}

val allMeatType: List<String> = listOf("돼지고기", "소고기", "닭고기", "가공육류")
val allEnvType: List<String> = listOf("후라이펜", "직화", "연탄", "가공육")
val allPartType: List<String> = listOf("머리", "가슴", "배", "다리")
val allRoastType: List<String> = listOf("생", "레어", "미디움", "딱딱해", "거의 ")
