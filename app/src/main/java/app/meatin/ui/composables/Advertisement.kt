package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.ui.theme.DisableLightGray2
import app.meatin.ui.theme.Typography
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
            .size(343.dp, 88.dp)
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
            contentScale = ContentScale.Crop,
        )

        Column(
            Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = title,
                style = Typography.h1,
                color = Color.White
            )
            Text(
                text = subtitle,
                style = Typography.caption,
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
