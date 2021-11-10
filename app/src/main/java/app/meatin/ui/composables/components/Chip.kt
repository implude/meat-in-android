package app.meatin.ui.composables.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.meatin.domain.model.Comment
import app.meatin.domain.model.FakeValues
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import app.meatin.util.defaultDateFormatter
import app.meatin.util.toDate
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
@Composable
fun Chip(
    modifier: Modifier = Modifier,
) {
    Row(modifier) {

    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun ChipPreview() {
    Chip(
    )
}
