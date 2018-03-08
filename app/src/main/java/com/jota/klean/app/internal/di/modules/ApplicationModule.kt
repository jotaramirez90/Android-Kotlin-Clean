package com.jota.klean.app.internal.di.modules

import android.content.Context
import com.jota.klean.app.App
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
}