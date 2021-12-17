package app.meatin.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.meatin.ui.theme.Flamingo
import app.meatin.ui.theme.MeatInTypography
import app.meatin.ui.theme.composefix.CoreText
import app.meatin.ui.viewmodel.RecipeViewModel
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
@Composable
fun RecipeStepScreen(
    navController: NavController,
    recipeViewModel: RecipeViewModel,
) {
    var index by remember { mutableStateOf(0) }
    val recipe = recipeViewModel.recipe.collectAsState()
    val recipeSteps = recipeViewModel.recipeSteps.collectAsState()

    if (index == recipeSteps.value.size) {
        RecipeCookFin(navController = navController, briefRecipe = recipe.value.toBrief()) {
            navController.popBackStack()
        }
    } else {
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            InnerRecipeStepScreen(
                index = index,
                title = recipe.value.name,
                recipeSteps = recipeSteps.value,
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = {
                    index += 1
                },
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 48.dp)
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Flamingo
                )
            ) {
                CoreText(
                    text = when (index) {
                        0 -> "시작하기"
                        else -> "다음 단계"
                    },
                    style = MeatInTypography.sectionHeader,
                    color = Color.White
                )
            }
        }
    }
}