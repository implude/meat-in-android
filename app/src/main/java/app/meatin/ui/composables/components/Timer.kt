package app.meatin.ui.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.ui.theme.DarkFlamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Timer(
    modifier: Modifier = Modifier,
    second: Long,
    initialValue: Float = 1f,
) {

    var currentTime by remember {
        mutableStateOf(second)
    }
    var isTimerRunning by remember {
        mutableStateOf(true)
    }
    var value by remember {
        mutableStateOf(initialValue)
    }

    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if (currentTime == 0L) {
            isTimerRunning = false
        }
        if (currentTime > 0L && isTimerRunning) {
            delay(100L)
            currentTime -= 100L
            value = currentTime / second.toFloat()
        }
    }
    Box(
        modifier.drawBehind {
            for (i in 60 - (value * 60).toInt() until 60) {
                mark(angle = i * 6)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                elevation = 8.dp,
            ) {
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .clip(CircleShape)
                    .border(
                        8.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(100.dp)
                    ),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .size(200.dp)

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                            .clip(CircleShape)
                            .clickable(
                                onClick = {
                                    if (currentTime <= 0L) {
                                        currentTime = second
                                        isTimerRunning = true
                                    } else {

                                        isTimerRunning = !isTimerRunning
                                    }
                                }
                            )

                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .size(150.dp)
                                .background(Color.White)
                        ) {
                            ConstraintLayout {
                                val (text) = createRefs()
                                val timeColor = if (isTimerRunning) {
                                    DarkFlamingo
                                } else {
                                    Gray
                                }
                                CoreText(
                                    text = getTimerLabel(currentTime / 1000L),
                                    overflow = TextOverflow.Ellipsis,
                                    style = MeatInTypography.pageTitle,
                                    color = timeColor,
                                    modifier = Modifier.constrainAs(text) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        start.linkTo(parent.start)
                                        end.linkTo(parent.end)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

internal fun DrawScope.mark(
    angle: Int,
) {
    val theta = (angle - 90) * PI.toFloat() / 180f
    val startRadius = size.width / 2 * .69f
    val endRadius = size.width / 2 * .6f
    val startPos = Offset(cos(theta) * startRadius, sin(theta) * startRadius)
    val endPos = Offset(cos(theta) * endRadius, sin(theta) * endRadius)
    drawLine(
        color = Color.White,
        start = center + startPos,
        end = center + endPos,
        strokeWidth = 5f,
        cap = StrokeCap.Round
    )
}

fun getTimerLabel(value: Long): String {
    return if ((value.toInt() / 60) == 0) {
        "${padding(value.toInt() % 60)}초"
    } else {
        "${padding(value.toInt() / 60)}분 ${padding(value.toInt() % 60)}초"
    }
}

fun padding(value: Int) = if (value < 10) ("0$value") else "" + value

@Preview
@Composable
fun TimerPreview() {
    Timer(
        modifier = Modifier
            .size(width = 400.dp, height = 400.dp),
        second = 100L * 1000L,
    )
}