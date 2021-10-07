package app.meatin.ui.composables

import android.graphics.drawable.DrawableWrapper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import app.meatin.ui.theme.BoxTextDarkGray
import app.meatin.ui.theme.CoreText
import app.meatin.ui.theme.DisableLightGray2
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.net.URI
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@ExperimentalCoilApi
@Composable
fun TaggedRecipe(
    modifier: Modifier = Modifier,
    previewUri: URI,
    title: String,
    tags: List<String>,
    description: String,
    hearts: Int,
    date: LocalDateTime,
) {
    ConstraintLayout(
        modifier
            .background(Color.White)
    ) {
        val (
            previewImage,
            titleText,
            tagList,
            descriptionText,
            heartsText,
            dateText,
        ) = createRefs()

        Image(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.Gray)
                .constrainAs(previewImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                },
            painter = rememberImagePainter(
                data = previewUri.toASCIIString()
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        CoreText(
            modifier = Modifier
                .constrainAs(titleText) {
                    top.linkTo(parent.top)
                    start.linkTo(previewImage.end, 16.dp)
                    bottom.linkTo(tagList.top)
                },
            text = title,
            style = MeatInTypography.regularImportant,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        LazyRow(
            modifier = Modifier
                .constrainAs(tagList) {
                    top.linkTo(titleText.bottom, 4.dp)
                    start.linkTo(previewImage.end, 16.dp)
                    bottom.linkTo(descriptionText.top)
                },
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(tags) {
                CoreText(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(DisableLightGray2)
                        .padding(
                            start = 10.dp,
                            top = 3.dp,
                            end = 10.dp,
                            bottom = 3.dp
                        ),
                    text = it,
                    style = MeatInTypography.subHeader.copy(fontSize = 12.sp, lineHeight = (12*1.5).sp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }

        }

        CoreText(
            modifier = Modifier
                .constrainAs(descriptionText) {
                    start.linkTo(previewImage.end, 16.dp)
                    top.linkTo(tagList.bottom, 4.dp)
                    bottom.linkTo(heartsText.top)
                },
            text = description,
            style = MeatInTypography.description,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )

        CoreText(
            modifier = Modifier
                .constrainAs(heartsText) {
                    start.linkTo(previewImage.end, 16.dp)
                    top.linkTo(descriptionText.bottom, 4.dp)
                    bottom.linkTo(parent.bottom)
                },
            text = hearts.toString(),
            style = MeatInTypography.subHeader.copy(fontSize = 12.sp, lineHeight = (12*1.5).sp),
            color = Flamingo,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        CoreText(
            modifier = Modifier
                .constrainAs(dateText) {
                    start.linkTo(heartsText.end, 10.dp)
                    top.linkTo(descriptionText.bottom, 4.dp)
                    bottom.linkTo(parent.bottom)
                },
            text = DateTimeFormatter.ofPattern("yyyy. MM. dd").format(date),
            style = MeatInTypography.subHeader.copy(fontSize = 12.sp, lineHeight = (12*1.5).sp),
            color = BoxTextDarkGray,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun TaggedRecipePreview() {
    TaggedRecipe(
        modifier = Modifier
            .size(width = 343.dp, height = 120.dp),
        previewUri = URI("https://naver.com"),
        title = "육즙 가득한 삼겹살",
        tags = listOf("삼겹살", "쉬움", "30분 소요"),
        description = "집에서도 육즙 가득하게 삽겹 고기 전문점에서 먹는 맛을 낼 수 있을 거예요 아마도 아마도",
        hearts = 10,
        date = LocalDateTime.of(2021, 9, 16 , 1, 0, 0))
}