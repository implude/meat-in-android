package app.meatin.ui.composables.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.R
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Timer(
    modifier: Modifier = Modifier,
    second: Int,
) {
    val compositionSpec by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loadinground))
    val progress by animateLottieCompositionAsState(compositionSpec,iterations = LottieConstants.IterateForever,)

    Box(modifier) {
        for (i in 0 until 60) {
            Marker(
                angle = i * 6,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    elevation = 8.dp,
                ){
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                        .clip(CircleShape)
                        .border(
                            6.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(100.dp)
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
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .size(150.dp)
                                    .background(Color.White)
                            ) {
                                ConstraintLayout {
                                    val (animation, text) = createRefs()
                                    LottieAnimation(
                                        compositionSpec,
                                        progress,
                                        modifier = Modifier
                                            .size(200.dp)
                                            .constrainAs(animation) {
                                                top.linkTo(parent.top)
                                                bottom.linkTo(parent.bottom)
                                                start.linkTo(parent.start)
                                                end.linkTo(parent.end)
                                            },
                                    )
                                    CoreText(
                                        text = getTimerLabel(second),
                                        overflow = TextOverflow.Ellipsis,
                                        style = MeatInTypography.pageTitle,
                                        color = Flamingo,
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
}

@Composable
internal fun Marker(
    angle: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxSize()
            .drawBehind {
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
    )
}
@Preview
@Composable
fun TimerPreview() {
    Timer(
        modifier = Modifier
            .size(width = 400.dp, height = 400.dp),
        second = 15,
    )
}

fun getTimerLabel(value: Int): String {
    return if((value / 60) == 0) {
        "${padding(value % 60)}초"
    } else {
        "${padding(value / 60)}분 ${padding(value % 60)}초"
    }
}


fun padding(value: Int) = if (value < 10) ("0$value") else "" + value