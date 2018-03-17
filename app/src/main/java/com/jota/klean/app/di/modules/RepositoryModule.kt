package com.jota.klean.app.di.modules

import com.jota.klean.data.repository.DataRepository
import com.jota.klean.domain.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jotaramirez on 12/3/18.
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
            dataRepository: DataRepository): Repository = dataRepository
}