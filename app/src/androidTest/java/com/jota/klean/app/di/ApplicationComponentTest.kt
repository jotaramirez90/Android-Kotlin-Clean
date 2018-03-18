package com.jota.klean.app.di

import com.jota.klean.app.di.modules.ApplicationModule
import com.jota.klean.app.di.modules.RepositoryModule
import com.jota.klean.ui.features.main.MainActivityTest
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Jota Ramirez on 18/3/18.
 */
@Singleton
@Component(modules = [(ApplicationModule::class), (RepositoryModule::class)])
interface ApplicationComponentTest {

    fun inject(mainActivityTest: MainActivityTest)
}