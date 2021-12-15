package app.meatin.ui.di

import app.meatin.ui.viewmodel.AuthViewModel
import app.meatin.ui.viewmodel.MainViewModel
import app.meatin.ui.viewmodel.PostViewModel
import app.meatin.ui.viewmodel.RecipeViewModel
import app.meatin.util.SharedPreferencesManager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { MainViewModel(get(), get()) }
    viewModel { PostViewModel(get()) }
    viewModel { RecipeViewModel(get()) }

    single { SharedPreferencesManager(androidContext()) }
}
