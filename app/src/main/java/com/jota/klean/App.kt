package com.jota.klean

import android.app.Application
import com.jota.klean.app.internal.di.components.ApplicationComponent
import com.jota.klean.app.internal.di.components.DaggerApplicationComponent
import com.jota.klean.app.internal.di.modules.ApplicationModule

/**
 * Created by jotaramirez on 8/3/18.
 */
class App : Application() {

    val mAppComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        mAppComponent.inject(this)
    }
}