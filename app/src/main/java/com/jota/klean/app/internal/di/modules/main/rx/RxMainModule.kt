package com.jota.klean.app.internal.di.modules.main.rx

import com.jota.klean.ui.features.main.rx.RxMainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Jota Ramirez on 16/3/18.
 */
@Module
class RxMainModule {

    @Provides
    fun provideMainFragmentPresenter() = RxMainPresenter()
}