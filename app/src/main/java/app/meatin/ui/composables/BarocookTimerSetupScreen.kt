package app.meatin.ui.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.meatin.R
import app.meatin.ui.composables.components.ChipGroup
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun BarocookTimerSetupScreen(
    modifier: Modifier = Modifier,
) {
    val allMeatType: List<String> = listOf("돼지고기", "소고기", "닭고기", "가공육류")
    val allPartType: List<String> = listOf("머리", "가슴", "배", "다리")
    val allEnvType: List<String> = listOf("후라이펜", "직화", "연탄", "가공육")
    val allRoastType: List<String> = listOf("생", "레어", "미디움", "딱딱해", "거의 ")

    Column {
        Column(
            modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(
                modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_left_arrow),
                    contentDescription = "left_arrow"
                )
                CoreText(
                    text = "바로 굽기 타이머",
                    modifier
                        .padding(start = 12.dp),
                    style = MeatInTypography.pageTitle
                )
            }
            Column(
                modifier.padding(top = 37.dp)
            ) {
                var selectedMeatType: String? by remember { mutableStateOf(allMeatType[0]) }
                CoreText(
                    text = "고기 종류",
                    modifier.padding(bottom = 8.dp),
                    style = MeatInTypography.regularImportant
                )
                ChipGroup(
                    value = allMeatType,
                    selectedValue = selectedMeatType,
                    onSelectedChanged = {
                        Log.d("select", it)
                        selectedMeatType = it
                    }
                )
            }
            Column(
                modifier.padding(top = 20.dp)
            ) {
                var selectedPartType: String? by remember { mutableStateOf(allPartType[0]) }
                CoreText(
                    text = "부위",
                    modifier.padding(bottom = 8.dp),
                    style = MeatInTypography.regularImportant
                )
                ChipGroup(
                    value = allPartType,
                    selectedValue = selectedPartType,
                    onSelectedChanged = {
                        Log.d("select", it)
                        selectedPartType = it
                    }
                )
            }
            Column(
                modifier.padding(top = 20.dp)
            ) {
                var selectedRoastType: String? by remember { mutableStateOf(allRoastType[0]) }
                CoreText(
                    text = "굽기 정도",
                    modifier.padding(bottom = 8.dp),
                    style = MeatInTypography.regularImportant
                )
                ChipGroup(
                    value = allRoastType,
                    selectedValue = selectedRoastType,
                    onSelectedChanged = {
                        Log.d("select", it)
                        selectedRoastType = it
                    }
                )
            }
            Column(
                modifier.padding(top = 20.dp, bottom = 38.dp)
            ) {
                var selectedEnvType: String? by remember { mutableStateOf(allEnvType[0]) }
                CoreText(
                    text = "환경",
                    modifier.padding(bottom = 8.dp),
                    style = MeatInTypography.regularImportant
                )
                ChipGroup(
                    value = allEnvType,
                    selectedValue = selectedEnvType,
                    onSelectedChanged = {
                        Log.d("select", it)
                        selectedEnvType = it
                    }
                )
            }
        }
        Spacer(
            modifier
                .background(color = Color(0xFFF1F3F5))
                .fillMaxWidth()
                .height(8.dp)
        )
        Column(
            modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(horizontal = 24.dp)
        ) {
            CoreText(
                text = "세팅",
                modifier.padding(top = 42.dp),
                style = MeatInTypography.sectionHeader
            )
            CoreText(
                text = "돼지고기 머리부위를 생으로 후라이펜에 구워요",
                style = MeatInTypography.bigDescription.copy(color = Color.DarkGray,
                    fontSize = 16.sp)
            )
            Row(
                modifier.padding(top = 18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CoreText(
                    text = "365",
                    style = MeatInTypography.pageTitle.copy(
                        color = Flamingo,
                        fontSize = 26.sp
                    )
                )
                CoreText(
                    text = " 분 동안",
                    style = MeatInTypography.regularImportant.copy(
                        fontSize = 24.sp
                    )
                )
            }
            Row(
                modifier.padding(top = 5.dp, bottom = 90.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CoreText(
                    text = "12476",
                    style = MeatInTypography.pageTitle.copy(
                        color = Flamingo,
                        fontSize = 26.sp
                    )
                )
                CoreText(
                    text = " 번 뒤집어요",
                    style = MeatInTypography.regularImportant.copy(
                        fontSize = 24.sp
                    )
                )
            }
        }
    }
}

@ExperimentalComposeUiApi
@Preview
@ExperimentalCoilApi
@Composable
fun BarocookTimerSetupScreenPreview() {
    BarocookTimerSetupScreen()
}
