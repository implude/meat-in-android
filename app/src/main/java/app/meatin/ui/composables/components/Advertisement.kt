package app.meatin.ui.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.meatin.ui.theme.DisableLightGray2
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.net.URI

@ExperimentalCoilApi
@Composable
fun Advertisement(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageUri: URI,
    onClick: () -> Unit,
) {
    Box(
        modifier
            .height(88.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable { onClick() }
            .background(Color.White)
    ) {
        Image(
            modifier = Modifier
                .background(DisableLightGray2),
            painter = rememberImagePainter(
                data = imageUri.toASCIIString()
            ),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )

        Column(
            Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart)
        ) {
            CoreText(
                text = title,
                style = MeatInTypography.sectionHeader,
                color = Color.White
            )
            CoreText(
                text = subtitle,
                style = MeatInTypography.regularImportant
                    .copy(fontSize = 12.sp),
                color = Color.White
            )
        }
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun AdvertisementPreview() {
    Advertisement(
        title = "무한리필로 최고의 맛을 즐기세요 응애",
        subtitle = "15,900원이라는 합리적인 가격으로!",
        imageUri = URI("https://ychef.files.bbci.co.uk/976x549/p04kt0s1.jpg"),
        onClick = {}
    )
}
