package app.meatin.data.di

import app.meatin.data.network.AuthInterceptor
import app.meatin.data.repositories.AuthRepositoryImpl
import app.meatin.data.repositories.PostRepositoryImpl
import app.meatin.data.repositories.RecipeRepositoryImpl
import app.meatin.data.repositories.UserRepositoryImpl
import app.meatin.domain.repositories.AuthRepository
import app.meatin.domain.repositories.PostRepository
import app.meatin.domain.repositories.RecipeRepository
import app.meatin.domain.repositories.UserRepository
import app.meatin.domain.services.MeatInService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl("http://34.64.200.191:3000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<MeatInService> {
        get<Retrofit>().create(MeatInService::class.java)
    }

    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }

    single<PostRepository> {
        PostRepositoryImpl(get())
    }

    single<RecipeRepository> {
        RecipeRepositoryImpl(get())
    }

    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}
