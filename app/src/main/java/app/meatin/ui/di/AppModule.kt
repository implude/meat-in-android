package app.meatin.ui.di

import app.meatin.data.network.AuthInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl("34.64.200.191:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
