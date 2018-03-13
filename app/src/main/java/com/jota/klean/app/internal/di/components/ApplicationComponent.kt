package com.jota.klean.app.internal.di.components

import android.content.Context
import com.jota.klean.app.App
import com.jota.klean.app.internal.di.components.details.DetailsComponent
import com.jota.klean.app.internal.di.components.main.MainComponent
import com.jota.klean.app.internal.di.modules.ApplicationModule
import com.jota.klean.app.internal.di.modules.RepositoryModule
import com.jota.klean.app.internal.di.modules.details.DetailsModule
import com.jota.klean.app.internal.di.modules.main.MainModule
import com.jota.klean.app.navigator.INavigator
import com.jota.klean.app.navigator.Navigator
import com.jota.klean.domain.executor.PostExecutionThread
import com.jota.klean.domain.executor.ThreadExecutor
import com.jota.klean.domain.repository.Repository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by jotaramirez on 8/3/18.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, RepositoryModule::class))
interface ApplicationComponent {

    fun inject(application: App)

    fun plus(mainModule: MainModule): MainComponent

    fun plus(detailsModule: DetailsModule): DetailsComponent

    fun context(): Context

    fun navigator(): INavigator

    fun repository(): Repository

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread
}