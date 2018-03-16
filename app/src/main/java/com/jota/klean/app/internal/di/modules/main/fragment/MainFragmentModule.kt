package com.jota.klean.app.internal.di.modules.main.fragment

import com.jota.klean.ui.features.main.fragment.MainFragmentPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Jota Ramirez on 16/3/18.
 */
@Module
class MainFragmentModule {

    @Provides
    fun provideMainFragmentPresenter() = MainFragmentPresenter()
}