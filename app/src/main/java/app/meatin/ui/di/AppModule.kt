package app.meatin.ui.di

import app.meatin.ui.viewmodel.MainViewModel
import app.meatin.ui.viewmodel.PostViewModel
import app.meatin.ui.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { PostViewModel(get()) }
    viewModel { RecipeViewModel(get()) }
}
