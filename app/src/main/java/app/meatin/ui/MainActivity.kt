package app.meatin.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.meatin.domain.model.FakeValues
import app.meatin.domain.model.RecipeStep
import app.meatin.ui.composables.LoginScreen
import app.meatin.ui.composables.LoginState
import app.meatin.ui.composables.MainScreen
import app.meatin.ui.composables.PostDetailScreen
import app.meatin.ui.composables.RecipeOverviewScreen
import app.meatin.ui.composables.SplashScreen
import app.meatin.ui.theme.MeatInTheme
import app.meatin.ui.viewmodel.AuthViewModel
import app.meatin.ui.viewmodel.MainViewModel
import app.meatin.ui.viewmodel.PostViewModel
import app.meatin.ui.viewmodel.RecipeViewModel
import app.meatin.util.SharedPreferencesManager
import coil.annotation.ExperimentalCoilApi
import kotlinx.coroutines.delay
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

@OptIn(ExperimentalComposeUiApi::class, ExperimentalCoilApi::class)
class MainActivity : ComponentActivity() {

    private val authViewModel by viewModel<AuthViewModel>()
    private val recipeViewModel by viewModel<RecipeViewModel>()
    private val postViewModel by viewModel<PostViewModel>()
    private val mainViewModel by viewModel<MainViewModel>()
    private val sharedPreferences by inject<SharedPreferencesManager>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        setContent {
            MeatInTheme {
                val navController = rememberNavController()

                Surface(color = MaterialTheme.colors.background) {
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") {
                            SplashScreen()
                            LaunchedEffect(Unit) {
                                delay(2700L)

                                val email = sharedPreferences.loginEmail
                                val password = sharedPreferences.loginPassword

                                if (email == null || password == null) {
                                    navController.navigate("login") {
                                        popUpTo("splash") {
                                            inclusive = true
                                        }
                                    }
                                } else {
                                    authViewModel.login(email, password).invokeOnCompletion {
                                        if (it == null) {
                                            navController.navigate("main") {
                                                popUpTo("splash") {
                                                    inclusive = true
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        composable("login") {
                            var state by remember { mutableStateOf(LoginState.NICKNAME) }

                            LoginScreen(
                                loginState = state,
                                onNicknameConfirm = {
                                    state = LoginState.PASSWORD
                                },
                                onBackPressedInPassword = {
                                    state = LoginState.NICKNAME
                                },
                                onCredentialConfirm = { email, password ->
                                    authViewModel.login(email, password).invokeOnCompletion {
                                        if (it == null) {
                                            sharedPreferences.applyCredentials(email, password)
                                            navController.navigate("main") {
                                                popUpTo("login") {
                                                    inclusive = true
                                                }
                                            }
                                        }
                                    }
                                }
                            )
                        }
                        composable("main") {
                            LaunchedEffect(Unit) {
                                mainViewModel.fetch()
                            }

                            val posts by mainViewModel.curatedPosts.observeAsState()
                            val recipes by mainViewModel.curatedRecipes.observeAsState()

                            MainScreen(
                                Modifier.fillMaxWidth(),
                                navController,
                                0,
                                FakeValues.ADVERTISEMENT,
                                recipes ?: listOf(),
                                posts ?: listOf()
                            )
                        }
                        composable(
                            "recipe_overview/{recipeId}",
                            arguments = listOf(navArgument("recipeId") { type = NavType.StringType })
                        ) {
                            LaunchedEffect(Unit) {
                                val recipeId = it.arguments?.getString("recipeId") ?: return@LaunchedEffect
                                recipeViewModel.fetch(recipeId)
                            }

                            val recipe by recipeViewModel.recipe.observeAsState()
                            val recipeSteps by recipeViewModel.recipeSteps.observeAsState()

                            RecipeOverviewScreen(
                                recipe = recipe?.copy(briefContent = recipeSteps?.map(RecipeStep::content) ?: listOf())
                                    ?: return@composable,
                                navController = navController,
                                onProfileButtonClick = { /*TODO*/ },
                                onCookButtonClicked = { /*TODO*/ },
                                onHeartChanged = { },
                            )
                        }
                        composable(
                            "post_detail/{postId}",
                            arguments = listOf(navArgument("postId") { type = NavType.StringType })
                        ) {
                            LaunchedEffect(Unit) {
                                val postId = it.arguments?.getString("postId") ?: return@LaunchedEffect
                                postViewModel.fetch(postId)
                            }

                            val post by postViewModel.post.observeAsState()

                            PostDetailScreen(
                                post = post ?: return@composable,
                                navController = navController,
                                onCommentAdd = {
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MeatInTheme {
        Greeting("Android")
    }
}
