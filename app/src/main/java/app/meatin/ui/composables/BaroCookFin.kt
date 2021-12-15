package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.R
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText

@Composable
fun BaroCookFin(
    meatPart: String,
    meatType: String,
    degree: String,
    situation: String,
    onWritePost: ()-> Unit,
) {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (title, info) = createRefs()
        Column(
            Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(info.top)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoreText(text = "고기가 맛있게 구워졌어요", style = MeatInTypography.bigDescription)
            CoreText(text = "맛있는 식사 되세요!", style = MeatInTypography.description)
        }
        Card(
            Modifier
                .constrainAs(info) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(4.dp),
            elevation = 2.dp
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                CoreText(text = "방금 구워진 고기", style = MeatInTypography.sectionHeader)
                Row(Modifier.padding(top = 9.dp)) {
                    TitledLabel(title = "종류", subtitle = meatType) {}
                    Spacer(modifier = Modifier.width(8.dp))
                    TitledLabel(title = "부위", subtitle = meatPart) {}
                }
                Row(Modifier.padding(top = 8.dp)) {
                    TitledLabel(title = "굽기정도", subtitle = degree) {}
                    Spacer(modifier = Modifier.width(8.dp))
                    TitledLabel(title = "상황", subtitle = situation) {}
                }
                Button(
                    onClick = onWritePost,
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(top = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        Flamingo
                    ),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        CoreText(
                            text = "포스트 작성하러 가기",
                            style = MeatInTypography.sectionHeader,
                            color = Color.White
                        )
                        Spacer(Modifier.width(8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_right_arrow2),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun BaroCookFinPreview() {
    BaroCookFin(
        meatType = "돼지고기",
        meatPart = "머릿고기",
        degree = "레어",
        situation = "용의 숨결...",
        onWritePost = {},
    )
}
