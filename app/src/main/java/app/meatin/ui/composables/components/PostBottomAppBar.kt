package app.meatin.ui.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.R
import app.meatin.ui.theme.DarkFlamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText

@Composable
fun PostBottomAppBar(
    modifier: Modifier = Modifier,
    isHearted: Boolean,
    onToPostClick: () -> Unit,
    onHeartClick: ((Boolean) -> Unit)?,
    onBookmartClick: ((Boolean) -> Unit)?,
    onShareClick: () -> Unit,
    isBookmarked: Boolean,
    hearts: Int,
) {
    BottomAppBar(
        modifier
            .height(56.dp),
        backgroundColor = Color.White,
        contentPadding = PaddingValues(0.dp),
    ) {
        ConstraintLayout(
            modifier.fillMaxSize()
        ) {
            val (
                heartIcon,
                heartCount,
                bookmarkIcon,
                shareIcon,
                exit,
            ) = createRefs()
            Row(
                modifier
                    .clickable { onToPostClick() }
                    .constrainAs(exit) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, 16.dp)
                    }, verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier,
                    painter = painterResource(R.drawable.ic_left_arrow),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(12.dp))
                CoreText(
                    modifier = Modifier,
                    text = "게시글",
                    style = MeatInTypography.sectionHeader,
                )
            }
            val heartToggleable =
                if (onHeartClick != null) {
                    Modifier.toggleable(
                        value = isHearted,
                        onValueChange = onHeartClick,
                    )
                } else {
                    Modifier
                }
            val heartImage = if (isHearted) {
                R.drawable.ic_heart2_filled
            } else {
                R.drawable.ic_heart2
            }
            Icon(
                modifier = Modifier
                    .then(heartToggleable)
                    .constrainAs(heartIcon) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(heartCount.start, 4.dp)
                    },
                painter = painterResource(heartImage),
                contentDescription = null,
                tint = DarkFlamingo
            )
            CoreText(
                modifier = Modifier
                    .constrainAs(heartCount) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(bookmarkIcon.start, 16.dp)
                    },
                text = hearts.toString(),
                style = MeatInTypography.regular,
            )
            val bookmarkToggleable =
                if (onBookmartClick != null) {
                    Modifier.toggleable(
                        value = isBookmarked,
                        onValueChange = onBookmartClick,
                    )
                } else {
                    Modifier
                }
            val bookmarkImage = if (isBookmarked) {
                R.drawable.ic_bookmark_filled
            } else {
                R.drawable.ic_bookmark
            }
            Icon(
                modifier = Modifier
                    .then(bookmarkToggleable)
                    .constrainAs(bookmarkIcon) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(shareIcon.start, 16.dp)
                    },
                painter = painterResource(bookmarkImage),
                contentDescription = null
            )
            Icon(
                modifier = Modifier
                    .clickable { onShareClick() }
                    .constrainAs(shareIcon) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end, 16.dp)
                    },
                painter = painterResource(R.drawable.ic_share),
                contentDescription = null
            )
        }
    }

}


@Preview
@Composable
fun PostBottomAppBarPreview() {
    var checkedBookmark by remember { mutableStateOf(false) }
    var checkedHeart by remember { mutableStateOf(false) }

    PostBottomAppBar(
        Modifier,
        isHearted = checkedHeart,
        hearts = 11,
        isBookmarked = checkedBookmark,
        onBookmartClick = { checkedBookmark = it },
        onHeartClick = { checkedHeart = it },
        onToPostClick = {},
        onShareClick = {})
}