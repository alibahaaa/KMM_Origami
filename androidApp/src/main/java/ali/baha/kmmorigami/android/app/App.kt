package ali.baha.kmmorigami.android.app

import ali.baha.kmmorigami.android.di.appModule
import ali.baha.kmmorigami.di.initKoin
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent

class App : Application() , KoinComponent {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}