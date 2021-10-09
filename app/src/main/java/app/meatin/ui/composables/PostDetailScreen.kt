package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.net.URI

@ExperimentalCoilApi
@Composable
fun PostDetailScreen(
    modifier: Modifier = Modifier,
    titleImageURI: URI
) {
    ConstraintLayout(
        modifier
            .background(Color.White)
    ) {
        val (
            titleImage,
            profileButton,
        ) = createRefs()

        Image(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Gray)
                .constrainAs(titleImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = rememberImagePainter(
                data = titleImageURI.toASCIIString()
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        ProfileButton(
            modifier = Modifier
                .constrainAs(profileButton) {
                    start.linkTo(parent.start)
                },
            profileUri = URI("https://naver.com"),
            badgeUri = URI("https://naver.com"),
            onClick = { /*TODO*/ },
            classes = "유사 백선생",
            classesColor = Color(0xFFFFA318),
            username = "김응애"
        )

    }
}

@Preview
@ExperimentalCoilApi
@Composable
fun PostDetailScreenPreview() {
    PostDetailScreen(
        titleImageURI = URI("https://naver.com")
    )
}

