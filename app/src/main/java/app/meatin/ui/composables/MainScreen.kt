package app.meatin.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import app.meatin.domain.model.AdvertisementModel
import app.meatin.domain.model.BriefCommunityUser
import app.meatin.domain.model.FakeValues
import app.meatin.ui.composables.components.Advertisement
import app.meatin.ui.theme.composefix.CoreText
import coil.annotation.ExperimentalCoilApi
import java.net.URI

@ExperimentalCoilApi
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    profile:List<BriefCommunityUser>,
    advertisement: AdvertisementModel,
){
   Scaffold(
      content = {
          Column(
          modifier
              .background(color = Color(0xFFE5E5E5))
              .fillMaxSize()
              .verticalScroll(rememberScrollState())
              .padding(bottom = 50.dp)
      ){
          ConstraintLayout(
              modifier
                  .background(Color.White)
                  .fillMaxWidth()
          ) {
              CoreText(text = "MEAT . IN")
              Advertisement(
                  title = advertisement.title,
                  subtitle = advertisement.subtitle,
                  imageUri = URI(advertisement.imageUri),
              ) {
                  
              }
          }
      } }
   )
}

@ExperimentalCoilApi
@Preview
@Composable
fun MainScreenPreview(){
    MainScreen(
        profile = listOf(FakeValues.BRIEF_COMMUNITY_USER, FakeValues.BRIEF_COMMUNITY_USER),
        advertisement = FakeValues.ADVERTISEMENT
    )
}