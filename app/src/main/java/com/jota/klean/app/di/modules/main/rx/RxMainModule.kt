package com.jota.klean.app.di.modules.main.rx

import com.jota.klean.app.di.scope.PerView
import com.jota.klean.domain.executor.PostExecutionThread
import com.jota.klean.domain.executor.ThreadExecutor
import com.jota.klean.domain.interactor.rx.GetWeatherRx
import com.jota.klean.domain.repository.Repository
import com.jota.klean.model.mapper.CityWeatherViewModelMapper
import com.jota.klean.ui.features.main.rx.RxMainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Jota Ramirez on 16/3/18.
 */
@Module
class RxMainModule {

    @Provides
    @PerView
    fun provideGetWeatherRx(repository: Repository,
                            threadExecutor: ThreadExecutor,
                            postExecutionThread: PostExecutionThread) =
            GetWeatherRx(repository, threadExecutor, postExecutionThread)

    @Provides
    fun provideRxMainPresenter(
            getWeatherRx: GetWeatherRx,
            cityWeatherViewModelMapper: CityWeatherViewModelMapper
    ) = RxMainPresenter(getWeatherRx, cityWeatherViewModelMapper)
}