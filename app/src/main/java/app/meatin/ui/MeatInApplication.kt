package app.meatin.ui

import android.app.Application
import app.meatin.data.di.networkModule
import app.meatin.ui.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MeatInApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MeatInApplication)
            modules(networkModule, appModule)
        }
    }
}
