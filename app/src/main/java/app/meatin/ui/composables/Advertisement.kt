package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.ui.theme.DarkFlamingo
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
    imageUri : URI,
    onClick:() -> Unit,
    ){
    Box(modifier
        .size(343.dp, 88.dp)
        .clip(RoundedCornerShape(5.dp))
        .clickable { onClick() }
        .background(Color.White)
    ) {
        Image(
            modifier = Modifier
                .height(72.dp)
                .background(DisableLightGray2),
            painter = rememberImagePainter(
                data = imageUri.toASCIIString()
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Box(Modifier.padding(start = 5.dp,top =30.dp )){
            Column() {
                Text(text = title.toString(),style = Typography.h1,color = Color.White)
                Text(text = subtitle.toString(),style = Typography.body1,color = Color.White)
            }

        }

    }

}

@ExperimentalCoilApi
@Preview
@Composable
fun AdvertisementPreview() {
    Advertisement(
        Modifier.padding(10.dp),
        title = "나이아가라 폭포",
        subtitle = "집에서도 시원한 나이아가라 폭포를 즐겨보세요.",
        imageUri = URI("https://ychef.files.bbci.co.uk/976x549/p04kt0s1.jpg"),
        onClick = {}
    )
}
