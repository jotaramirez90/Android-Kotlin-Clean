package com.jota.klean.app.di.modules.main

import com.jota.klean.ui.features.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by jotaramirez on 8/3/18.
 */
@Module
class MainModule {

    @Provides
    fun provideMainPresenter() = MainPresenter()
}