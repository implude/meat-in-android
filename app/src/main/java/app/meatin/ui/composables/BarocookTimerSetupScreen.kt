package app.meatin.ui.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.RelocationRequester
import androidx.compose.ui.layout.relocationRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import app.meatin.R
import app.meatin.domain.model.BriefCommunityUser
import app.meatin.domain.model.FakeValues
import app.meatin.domain.model.Post
import app.meatin.ui.composables.components.ChipGroup
import app.meatin.ui.composables.components.CommentItem
import app.meatin.ui.composables.components.PostBottomAppBar
import app.meatin.ui.composables.components.ProfileButton
import app.meatin.ui.composables.components.TaggedRecipe
import app.meatin.ui.composables.components.allEnvType
import app.meatin.ui.composables.components.allMeatType
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import app.meatin.util.defaultDateFormatter
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.net.URI

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun BarocookTimerSetupScreen(
    modifier: Modifier = Modifier,
) {
    val allMeatType: List<String> = listOf("돼지고기", "소고기", "닭고기", "가공육류")
    val allEnvType: List<String> = listOf("후라이펜", "직화", "연탄", "가공육")
    val allPartType: List<String> = listOf("머리", "가슴", "배", "다리")
    val allRoastType: List<String> = listOf("생", "레어", "미디움", "딱딱해", "거의 ")

    Column(
        modifier
            .background(color = Color.White)
    ) {
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
            modifier
        ) {
            var selectedMeatType: String? by remember { mutableStateOf(allMeatType[0]) }
            CoreText(
                text = "고기 종류",
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
    }
}

@ExperimentalComposeUiApi
@Preview
@ExperimentalCoilApi
@Composable
fun BarocookTimerSetupScreenPreview() {
    BarocookTimerSetupScreen()
}
