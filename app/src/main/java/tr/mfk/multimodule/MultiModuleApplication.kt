package tr.mfk.multimodule

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import tr.mfk.app.BuildConfig

@HiltAndroidApp
class MultiModuleApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}