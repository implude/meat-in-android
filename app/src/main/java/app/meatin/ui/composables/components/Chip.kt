package app.meatin.ui.composables.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.domain.model.Comment
import app.meatin.domain.model.FakeValues
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import app.meatin.util.defaultDateFormatter
import app.meatin.util.toDate
import coil.annotation.ExperimentalCoilApi

@SuppressLint("UnrememberedMutableState")
@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun View() {
    var selectedCar: Car? by remember { mutableStateOf(Car.values()[0]) }
    ChipGroup(
        cars = getAllCars(),
        selectedCar = selectedCar,
        onSelectedChanged = {
            Log.d("select", it)
            selectedCar = getCar(it)
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
        modifier = Modifier.padding(4.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) Color.LightGray else MaterialTheme.colors.primary
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                }
            )
        ) {
            CoreText(
                text = name,
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ChipGroup(
    cars: List<Car> = getAllCars(),
    selectedCar: Car? = null,
    onSelectedChanged: (String) -> Unit = {},
) {
    Column(modifier = Modifier.padding(8.dp)) {
        LazyRow {
            items(cars) {
                Chip(
                    name = it.value,
                    isSelected = selectedCar == it,
                    onSelectionChanged = { it1 ->
                        onSelectedChanged(it1)
                    },
                )
            }
        }
    }
}

enum class Car(val value: String){
    AUDI("Audi"),
    VW("VW"),
    BMW("BWM"),
}

fun getAllCars(): List<Car>{
    return listOf(Car.AUDI, Car.VW, Car.BMW)
}

fun getCar(value: String): Car? {
    val map = Car.values().associateBy(Car::value)
    return map[value]
}