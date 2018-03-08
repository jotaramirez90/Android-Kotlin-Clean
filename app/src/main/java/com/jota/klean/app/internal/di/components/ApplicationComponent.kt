package com.jota.klean.app.internal.di.components

import android.content.Context
import com.jota.klean.app.App
import com.jota.klean.app.internal.di.components.main.MainComponent
import com.jota.klean.app.internal.di.modules.ApplicationModule
import com.jota.klean.app.internal.di.modules.main.MainModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by jotaramirez on 8/3/18.
 */
@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun inject(application: App)

    fun plus(mainModule: MainModule): MainComponent

    fun context(): Context
}