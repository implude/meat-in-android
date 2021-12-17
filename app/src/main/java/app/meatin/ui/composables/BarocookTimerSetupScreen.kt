package app.meatin.ui.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
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
import kotlin.random.Random

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun BarocookTimerSetupScreen(
    modifier: Modifier = Modifier,
    configured: (meatType: Int, partType: Int, roastType: Int, envType: Int, minutes: Int, flipTimes: Int) -> Unit,
) {
    val allMeatType: List<String> = listOf("돼지고기", "소고기", "닭고기", "딜리시미트 한돈", "딜리시미트 한우")
    val allPartType: List<String> = listOf("머리", "가슴", "배", "다리")
    val allPorkPartType: List<String> = listOf("삼겹살", "목살", "갈비", "부채살")
    val allDelishPorkPartType: List<String> = listOf("가브리살", "항정살", "삼겹살", "목살")
    val allDelishBeefPartType: List<String> = listOf("채끝", "등심")
    val allRoastType: List<String> = listOf("레어", "미디움 레어", "미디움", "웰던", "빠삭빠삭")
    val allEnvType: List<String> = listOf("후라이펜", "직화", "연탄")

    var selectedMeatType: String? by remember { mutableStateOf(allMeatType[0]) }
    var selectedPorkPartType: String? by remember { mutableStateOf(allPorkPartType[0]) }
    var selectedDelishPorkPartType: String? by remember { mutableStateOf(allDelishPorkPartType[0]) }
    var selectedDelishBeefPartType: String? by remember { mutableStateOf(allDelishBeefPartType[0]) }
    var selectedPartType: String? by remember { mutableStateOf(allPartType[0]) }
    var selectedRoastType: String? by remember { mutableStateOf(allRoastType[0]) }
    var selectedEnvType: String? by remember { mutableStateOf(allEnvType[0]) }

    Scaffold(
        content = {
            Column(
                modifier.verticalScroll(rememberScrollState())
            ) {
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
                        CoreText(
                            text = "부위",
                            modifier.padding(bottom = 8.dp),
                            style = MeatInTypography.regularImportant
                        )
                        when (selectedMeatType) {
                            "돼지고기" -> {
                                ChipGroup(
                                    value = allPorkPartType,
                                    selectedValue = selectedPorkPartType,
                                    onSelectedChanged = {
                                        Log.d("select", it)
                                        selectedPorkPartType = it
                                    }
                                )
                            }
                            "딜리시미트 한돈" -> {
                                ChipGroup(
                                    value = allDelishPorkPartType,
                                    selectedValue = selectedDelishPorkPartType,
                                    onSelectedChanged = {
                                        Log.d("select", it)
                                        selectedDelishPorkPartType = it
                                    }
                                )
                            }
                            "딜리시미트 한우" -> {
                                ChipGroup(
                                    value = allDelishBeefPartType,
                                    selectedValue = selectedDelishBeefPartType,
                                    onSelectedChanged = {
                                        Log.d("select", it)
                                        selectedDelishBeefPartType = it
                                    }
                                )
                            }
                            else -> {
                                ChipGroup(
                                    value = allPartType,
                                    selectedValue = selectedPartType,
                                    onSelectedChanged = {
                                        Log.d("select", it)
                                        selectedPartType = it
                                    }
                                )
                            }
                        }
                    }
                    Column(
                        modifier.padding(top = 20.dp)
                    ) {
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
                    val postPosition = when (selectedRoastType) {
                        allRoastType[0] -> "로"
                        allRoastType[1] -> "로"
                        allRoastType[2] -> "으로"
                        allRoastType[3] -> "으로"
                        allRoastType[4] -> "하게"
                        else -> "(으)로"
                    }
                    val meatType = when (selectedMeatType) {
                        "돼지고기" -> selectedPorkPartType
                        "딜리시미트 한돈" -> selectedDelishPorkPartType
                        "딜리시미트 한우" -> selectedDelishBeefPartType
                        else -> selectedPartType
                    }
                    CoreText(
                        text = "$selectedMeatType ${meatType}부위를 ${selectedRoastType + postPosition} ${selectedEnvType}에 구워요",
                        style = MeatInTypography.bigDescription.copy(
                            color = Color.DarkGray,
                            fontSize = 16.sp
                        )
                    )
                    Row(
                        modifier.padding(top = 18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CoreText(
                            text = (Random.nextInt(10 - 5) + 5).toString(),
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
                            text = (Random.nextInt(5 - 2) + 2).toString(),
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
        },
        bottomBar = {
            Box(modifier.background(Color.White)) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(56.dp),
                    onClick = {
//                              configured(allMeatType.indexOf(selectedMeatType), )
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Flamingo,
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        modifier = Modifier.size(22.dp),
                        painter = painterResource(id = R.drawable.ic_cook),
                        contentDescription = "Cook",
                    )
                    Spacer(Modifier.width(8.dp))
                    CoreText(
                        text = "고기 굽기 시작",
                        style = MeatInTypography.sectionHeader,
                        color = Color.White,
                    )
                }
            }
        }
    )
}

@ExperimentalComposeUiApi
@Preview
@ExperimentalCoilApi
@Composable
fun BarocookTimerSetupScreenPreview() {
    BarocookTimerSetupScreen(
        configured = {_, _, _, _, _, _ -> }
    )
}
