package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.RelocationRequester
import androidx.compose.ui.layout.relocationRequester
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.domain.model.Comment
import app.meatin.domain.model.FakeValues
import app.meatin.ui.composables.components.ProfileButton
import app.meatin.ui.composables.components.TaggedRecipe
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.net.URI
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun PostDetailScreen(
    modifier: Modifier = Modifier,
    titleImageURI: URI,
    title: String,
    date: LocalDateTime,
    description: String,
    comments: List<Comment>,
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
                user = FakeValues.BRIEF_COMMUNITY_USER,
                profileUri = FakeValues.BRIEF_COMMUNITY_USER.profileImage,
                onClick = { /*TODO*/ },
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
                recipe = FakeValues.BRIEF_RECIPE
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

            val relocationRequestor = remember { RelocationRequester() }

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
                    }
                    .fillMaxWidth()
                    .requiredHeight(51.dp)
                    .relocationRequester(relocationRequestor),
                value = "",
                onValueChange = {
                    relocationRequestor.bringIntoView()
                },
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xfff8f8f8),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Box {
                        CoreText(
                            text = "Search Destination",
                            style = MeatInTypography.regular,
                            modifier = Modifier.align(Alignment.CenterStart)
                        )
                    }
                }
            )

//            LazyColumn(
//                modifier = Modifier
//                    .constrainAs(commentItems) {
//                        start.linkTo(parent.start, 16.dp)
//                        end.linkTo(parent.end, 16.dp)
//                        top.linkTo(inputCommentTextField.bottom, 20.dp)
//                    },
//                verticalArrangement = Arrangement.spacedBy(20.dp)
//            ) {
//                items(comments) {
//                    CommentItem(
//                        badgeUri = "https://www.nemopan.com/files/attach/images/166591/207/339/014/e96e99e30becc3f29b8b6a4e1e20c1f8.jpg",
//                        classes = "유사 백선생",
//                        classesColor = Color(0xffFFA318),
//                        username = "박정한",
//                        date = LocalDateTime.of(2022, Month.FEBRUARY, 22, 22, 22, 22),
//                        content = "정말 맛있어보이네요,,^^ 저도  .. 아가들한테 해주야겠어요..^^,,"
//                    )
//                }
//            }
        }
    }
}

@ExperimentalComposeUiApi
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
        comments = listOf()
    )
}
