package app.meatin.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.meatin.ui.composables.components.Timer
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun BaroCookScreen(navController: NavController) {
    var state by remember { mutableStateOf(BaroCookState.PRE_COOK) }
    var meatType by remember { mutableStateOf("") }
    var partType by remember { mutableStateOf("") }
    var roastType by remember { mutableStateOf("") }
    var envType by remember { mutableStateOf("") }
    var minutes by remember { mutableStateOf(0L) }
    var flipTimes by remember { mutableStateOf(0) }

    when (state) {
        BaroCookState.PRE_COOK -> PreCookScreen(
            onConfigured = { _meatType, _partType, _roastType, _envType, _minutes, _flipTimes ->
                meatType = _meatType
                partType = _partType
                roastType = _roastType
                envType = _envType
                minutes = _minutes.toLong()
                flipTimes = _flipTimes

                if (meatType == "딜리시미트 한돈" && partType == "삼겹살" && roastType == "미디움" && envType == "후라이팬") {
                    navController.navigate("recipe_cook/153f69ce-6c47-40d3-a0e4-ec262261053a")
                } else {
                    state = BaroCookState.TIMER
                }
            }
        )
        BaroCookState.TIMER -> TimerScreen(minutes * 60 * 1000, flipTimes) { state = BaroCookState.POST_COOK }
        BaroCookState.POST_COOK -> BaroCookFin(
            meatPart = partType,
            meatType = meatType,
            degree = roastType,
            env = envType
        ) {
            navController.popBackStack()
        }
    }
}

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun PreCookScreen(
    onConfigured: (meatType: String, partType: String, roastType: String, envType: String, minutes: Int, flipTimes: Int) -> Unit,
) {
    BarocookTimerSetupScreen(configured = onConfigured)
}

@Composable
fun TimerScreen(totalTime: Long, totalFlips: Int, onTimerEnd: () -> Unit) {
    var remainingTime by remember { mutableStateOf(0L) }
    var remainingFlips by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .background(Flamingo)
            .fillMaxSize()
    ) {
        Timer(
            millisecond = totalTime,
            onRemainingTimeChange = {
                remainingTime = it
                remainingFlips = (remainingTime.toDouble() / totalTime * (totalFlips + 1)).toInt()
                if (it == 0L) {
                    onTimerEnd()
                }
            },
            modifier = Modifier.align(Alignment.Center)
        )
        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoreText(text = "남은 뒤집기 ${remainingFlips}번", color = Color.White, style = MeatInTypography.sectionHeader)
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .height(7.dp)
            ) {
                for (i in 0 until remainingFlips) {
                    Spacer(
                        Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .size(7.dp)
                    )
                }
            }
        }
    }
}

enum class BaroCookState {
    PRE_COOK,
    TIMER,
    POST_COOK,
}

@Preview
@Composable
fun TimerScreenPreview() {
    TimerScreen(totalTime = 20_000L, totalFlips = 3, onTimerEnd = {})
}
