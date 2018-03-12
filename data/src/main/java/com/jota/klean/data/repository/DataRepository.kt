package com.jota.klean.data.repository

import com.jota.klean.data.entity.mapper.CityWeatherEntityDataMapper
import com.jota.klean.data.repository.source.DataStoreFactory
import com.jota.klean.domain.model.CityWeather
import com.jota.klean.domain.repository.Repository
import io.reactivex.Observable
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import javax.inject.Inject

/**
 * Created by jotaramirez on 11/3/18.
 */
class DataRepository @Inject constructor(
        private val mDataStoreFactory: DataStoreFactory,
        private val mCityWeatherEntityDataMapper: CityWeatherEntityDataMapper
) : Repository {

    override fun getCityWeatherCoroutines(latitude: String, longitude: String): Deferred<CityWeather> {
        return async {
            val cloudDataCoroutines = mDataStoreFactory.createCloudDataCoroutines()
            val result = cloudDataCoroutines.getCityWeather(latitude, longitude)
            mCityWeatherEntityDataMapper.transform(result.await())
        }
    }

    override fun getCityWeatherRx(latitude: String, longitude: String): Observable<CityWeather> {
        val cloudDataRx = mDataStoreFactory.createCloudDataRx()
        return cloudDataRx.getCityWeather(latitude, longitude)
                .map { mCityWeatherEntityDataMapper.transform(it) }
    }
}