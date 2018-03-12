package com.jota.klean.app.internal.di.modules

import android.content.Context
import com.jota.klean.app.App
import com.jota.klean.app.executor.UIThread
import com.jota.klean.data.executor.JobExecutor
import com.jota.klean.domain.executor.PostExecutionThread
import com.jota.klean.domain.executor.ThreadExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jotaramirez on 8/3/18.
 */
@Module
class ApplicationModule(val app: App) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = app

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread
}