package com.jota.klean.app.internal.di.modules.main

import com.jota.klean.app.internal.di.annotation.PerView
import com.jota.klean.domain.executor.PostExecutionThread
import com.jota.klean.domain.executor.ThreadExecutor
import com.jota.klean.domain.interactor.coroutines.GetWeatherCoroutines
import com.jota.klean.domain.interactor.rx.GetWeatherRx
import com.jota.klean.domain.repository.Repository
import com.jota.klean.ui.features.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by jotaramirez on 8/3/18.
 */
@Module
class MainModule {

    @Provides
    @PerView
    fun provideGetWeatherCoroutines(repository: Repository) = GetWeatherCoroutines(repository)

    @Provides
    @PerView
    fun provideGetWeatherRx(repository: Repository,
                            threadExecutor: ThreadExecutor,
                            postExecutionThread: PostExecutionThread) =
            GetWeatherRx(repository, threadExecutor, postExecutionThread)

    @Provides
    fun provideMainPresenter(getWeatherCoroutines: GetWeatherCoroutines,
                             getWeatherRx: GetWeatherRx) =
            MainPresenter(getWeatherCoroutines, getWeatherRx)
}