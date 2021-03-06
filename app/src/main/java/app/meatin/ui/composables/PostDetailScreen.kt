package app.meatin.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.RelocationRequester
import androidx.compose.ui.layout.relocationRequester
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import app.meatin.domain.model.Post
import app.meatin.ui.composables.components.CommentItem
import app.meatin.ui.composables.components.PostBottomAppBar
import app.meatin.ui.composables.components.ProfileButton
import app.meatin.ui.composables.components.TaggedRecipe
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
fun PostDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    post: Post,
    onCommentAdd: () -> Unit,
) {
    Scaffold(
        content = {
            Column(
                modifier
                    .background(color = Color(0xFFE5E5E5))
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 50.dp)
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
                            data = URI(post.photos?.getOrNull(0) ?: "").toASCIIString()
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
                        text = post.title,
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
                        text = defaultDateFormatter.format(post.createdAt),
                        style = MeatInTypography.description,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )

                    ProfileButton(
                        modifier = Modifier
                            .constrainAs(profileButton) {
                                top.linkTo(dateText.bottom, 10.dp)
                                start.linkTo(parent.start, 16.dp)
                                end.linkTo(parent.end, 16.dp)
                            }
                            .shadow(1.dp),
                        user = post.author,
                        profileUri = post.author.photo ?: "",
                        onClick = { },
                    )

                    CoreText(
                        modifier = Modifier
                            .constrainAs(descriptionText) {
                                top.linkTo(profileButton.bottom, 16.dp)
                            }
                            .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
                        text = post.content,
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
                        text = "????????? ?????????",
                        style = MeatInTypography.sectionHeader
                    )

                    TaggedRecipe(
                        modifier = Modifier
                            .constrainAs(taggedRecipe) {
                                top.linkTo(taggedRecipeText.bottom, 12.dp)
                                width = Dimension.fillToConstraints
                            }
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                        recipe = post.linkedRecipe.copy(description = "??? ????????? ???????????? ????????? ?????? ???, ???????????????. ?????? ????????? ????????? ????????? ?????? ????????????. ????????? ?????? ?????? ?????? ????????? ?????? ???????????? ????????????. ?????? ??? ??? ?????? ??? ??????, ?????? ?????? ?????????, ????????????. ??? ??? ???, ????????? ?????? ?????? ?????????. ????????? ?????? ?????? ?????? ????????????. ????????? ?????? ????????? ?????? ????????? ?????? ?????? ??? ???????????????. ??? ?????? ?????? ????????? ???????????????. ????????? ?????? ?????????, ?????? ?????? ????????? ??? ??? ???????????????. ?????? ?????? ?????????, ???????????? ??? ????????????. ???????????? ?????? ??? ?????? ?????? ?????? ??? ??????????????????."),
                        onClick = {
                            navController.navigate("recipe_overview/${post.linkedRecipe.id}")
                        }
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

                    val relocationRequester = remember { RelocationRequester() }
                    val text = remember { mutableStateOf("") }

                    CoreText(
                        modifier = Modifier
                            .constrainAs(commentText) {
                                top.linkTo(parent.top, 16.dp)
                                start.linkTo(parent.start, 16.dp)
                            },
                        text = "??????",
                        style = MeatInTypography.sectionHeader
                    )
                    TextField(
                        modifier = Modifier
                            .constrainAs(inputCommentTextField) {
                                top.linkTo(commentText.bottom, 12.dp)
                                start.linkTo(parent.start, 16.dp)
                                end.linkTo(parent.end, 16.dp)
                                width = Dimension.fillToConstraints
                            }
                            .relocationRequester(relocationRequester),
                        value = text.value,
                        onValueChange = {
                            relocationRequester.bringIntoView()
                            text.value = it
                        },
                        shape = RoundedCornerShape(5.dp, 0.dp, 0.dp, 5.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xfff8f8f8),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        placeholder = {
                            CoreText(
                                modifier = Modifier
                                    .wrapContentHeight(),
                                text = "????????? ??????????????????",
                                style = MeatInTypography.regular.copy(color = Color(0xFF919191)),
                            )
                        },
                        trailingIcon = {
                            CoreText(
                                modifier = modifier
                                    .clickable(
                                        indication = null,
                                        interactionSource = MutableInteractionSource()
                                    ) { onCommentAdd() }
                                    .padding(start = 16.dp, end = 16.dp),
                                text = "??????",
                                color = Flamingo,
                                style = MeatInTypography.subHeader
                            )
                        },
                    )

                    Column(
                        modifier = Modifier
                            .constrainAs(commentItems) {
                                start.linkTo(parent.start, 16.dp)
                                end.linkTo(parent.end, 16.dp)
                                top.linkTo(inputCommentTextField.bottom, 20.dp)
                                bottom.linkTo(parent.bottom, 24.dp)
                                width = Dimension.fillToConstraints
                            },
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        for (comments in post.comments) {
                            CommentItem(comment = comments)
                        }
                    }
                }
            }
        },
        bottomBar = {
            var checkedBookmark by remember { mutableStateOf(false) }
            var checkedHeart by remember { mutableStateOf(false) }

            PostBottomAppBar(
                isHearted = checkedHeart,
                onToPostClick = {},
                onHeartClick = { checkedHeart = it },
                onBookmarkClick = { checkedBookmark = it },
                onShareClick = {},
                isBookmarked = checkedBookmark,
                hearts = post.heart?.count ?: 0
            )
        }
    )
}

// @ExperimentalComposeUiApi
// @Preview(heightDp = 10000)
// @ExperimentalCoilApi
// @Composable
// fun PostDetailScreenPreview() {
//     PostDetailScreen(
//         post = FakeValues.POST,
//         onCommentAdd = {}
//     )
// }
