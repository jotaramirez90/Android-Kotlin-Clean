package com.jota.klean.app.internal.di.modules.details

import com.jota.klean.ui.features.details.DetailsPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Jota Ramirez on 13/3/18.
 */
@Module
class DetailsModule {

    @Provides
    fun provideDetailsPresenter() = DetailsPresenter()
}