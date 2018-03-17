package com.jota.klean.app.di.modules.main.coroutines

import com.jota.klean.app.di.scope.PerView
import com.jota.klean.domain.interactor.coroutines.GetWeatherCoroutines
import com.jota.klean.domain.repository.Repository
import com.jota.klean.model.mapper.CityWeatherViewModelMapper
import com.jota.klean.ui.features.main.coroutines.CoroutinesMainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Jota Ramirez on 17/3/18.
 */
@Module
class CoroutinesMainModule {

    @Provides
    @PerView
    fun provideGetWeatherCoroutines(repository: Repository) = GetWeatherCoroutines(repository)

    @Provides
    fun provideCoroutinesMainPresenter(
            getWeatherCoroutines: GetWeatherCoroutines,
            cityWeatherViewModelMapper: CityWeatherViewModelMapper
    ) = CoroutinesMainPresenter(getWeatherCoroutines, cityWeatherViewModelMapper)
}