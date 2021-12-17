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
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.R
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
@Composable
fun RecipeCookFin(
    onWritePost: () -> Unit,
) {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        val (title, button) = createRefs()
        Column(
            Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(button.top)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoreText(text = "고기가 맛있게 구워졌어요", style = MeatInTypography.bigDescription)
            CoreText(text = "맛있는 식사 되세요!", style = MeatInTypography.description)
        }
        Button(
            onClick = onWritePost,
            modifier = Modifier
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
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
                    text = "레시피로 돌아가기",
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
