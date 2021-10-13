package app.meatin.ui.composables

import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import app.meatin.domain.model.Comment
import app.meatin.ui.theme.BoxTextDarkGray
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.net.URI
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

@ExperimentalCoilApi
@Composable
fun PostDetailScreen(
    modifier: Modifier = Modifier,
    titleImageURI: URI,
    title: String,
    date: LocalDateTime,
    description: String,
    comments: List<Comment>
) {
    Column(
        modifier
            .background(color = Color(0xFFE5E5E5))
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout(
            modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            val (
                titleImage,
                titleText,
                dateText,
                profileButton,
                descriptionText,
            ) = createRefs()

            Image(
                modifier = Modifier
                    .size(width = Dp.Infinity, height = 300.dp)
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

            CoreText(
                modifier = Modifier
                    .constrainAs(titleText) {
                        top.linkTo(titleImage.bottom, 16.dp)
                        start.linkTo(parent.start, 16.dp)
                    },
                text = title,
                style = MeatInTypography.sectionHeader,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            CoreText(
                modifier = Modifier
                    .constrainAs(dateText) {
                        top.linkTo(titleText.bottom, 6.dp)
                        start.linkTo(parent.start, 16.dp)
                    },
                text = DateTimeFormatter.ofPattern("yyyy. MM. dd").format(date),
                style = MeatInTypography.description,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            ProfileButton(
                modifier = Modifier
                    .constrainAs(profileButton) {
                        top.linkTo(dateText.bottom, 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .shadow(4.dp),
                profileUri = URI("https://naver.com"),
                badgeUri = URI("https://naver.com"),
                onClick = { /*TODO*/ },
                classes = "유사 백선생",
                classesColor = Color(0xFFFFA318),
                username = "김응애"
            )

            CoreText(
                modifier = Modifier
                    .constrainAs(descriptionText) {
                        top.linkTo(profileButton.bottom, 16.dp)
                        start.linkTo(parent.start, 16.dp)
                    }
                    .padding(bottom = 16.dp),
                text = description,
                style = MeatInTypography.regular,
                overflow = TextOverflow.Clip
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        ConstraintLayout(
            modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            val (
                taggedRecipeText,
                taggedRecipe,
            ) = createRefs()
            CoreText(
                modifier = Modifier
                    .constrainAs(taggedRecipeText) {
                        top.linkTo(parent.top, 16.dp)
                        start.linkTo(parent.start, 16.dp)
                    },
                text = "연결된 레시피",
                style = MeatInTypography.sectionHeader
            )

            TaggedRecipe(
                modifier = Modifier
                    .constrainAs(taggedRecipe) {
                        top.linkTo(taggedRecipeText.bottom, 12.dp)
                    }
                    .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                previewUri = URI("https://naver.com"),
                title = "육즙 가득한 삼겹살은 너무 맛있어서 천국으로 가버릴 것 같아요",
                tags = listOf("삼겹살", "쉬움", "30분 소요"),
                description = "집에서도 육즙 가득하게 삽겹 고기 전문점에서 먹는 맛을 낼 수 있을 거예요 아마도 아마도",
                hearts = 10,
                isHearted = true,
                date = LocalDateTime.of(2021, 9, 16, 1, 0, 0)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        ConstraintLayout(
            modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            val (
                commentText,
                inputCommentTextField,
                commentItems,
            ) = createRefs()

            CoreText(
                modifier = Modifier
                    .constrainAs(commentText) {
                        top.linkTo(parent.top, 16.dp)
                        start.linkTo(parent.start, 16.dp)
                    },
                text = "댓글",
                style = MeatInTypography.sectionHeader
            )

            TextField(
                modifier = Modifier
                    .constrainAs(inputCommentTextField) {
                        top.linkTo(commentText.bottom, 20.dp)
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                        bottom.linkTo(parent.bottom, 20.dp)
                        width = Dimension.fillToConstraints
                    }
                    .padding(10.dp),
                value = "value",
                onValueChange = { it }
            )

            LazyColumn(
                modifier = Modifier
                    .constrainAs(commentItems) {
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                        top.linkTo(inputCommentTextField.bottom, 20.dp)
                    },
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(comments) {
                    CommentItem(
                        badgeUri = "https://www.nemopan.com/files/attach/images/166591/207/339/014/e96e99e30becc3f29b8b6a4e1e20c1f8.jpg",
                        classes = "유사 백선생",
                        classesColor = Color(0xffFFA318),
                        username = "박정한",
                        date = LocalDateTime.of(2022, Month.FEBRUARY, 22, 22, 22, 22),
                        content = "정말 맛있어보이네요,,^^ 저도  .. 아가들한테 해주야겠어요..^^,,"
                    )
                }
            }
        }

    }
}

@Preview(heightDp = 10000)
@ExperimentalCoilApi
@Composable
fun PostDetailScreenPreview() {
    PostDetailScreen(
        titleImageURI = URI("https://naver.com"),
        title = "육즙 가득 삼겹살 굽기!!",
        date = LocalDateTime.of(2021, 9, 16, 1, 0, 0),
        description = "고백받았는데 내가 거절했어\n" +
                "한순간에 남같이 돌변하더라\n" +
                "너무힘들어 지금도 울고있어\n" +
                "보고싶다 매일밤 전화하던게\n" +
                "넘너무 그리워 내 목숨을 가져가도 좋아\n" +
                "제발 연락해줘",
        comments = listOf(Comment())
    )
}
