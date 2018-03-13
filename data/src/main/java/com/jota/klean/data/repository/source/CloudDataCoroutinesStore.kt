package com.jota.klean.data.repository.source

import com.jota.klean.data.BuildConfig
import com.jota.klean.data.entity.CityWeatherEntity
import com.jota.klean.data.net.coroutines.ApiCoroutines
import kotlinx.coroutines.experimental.Deferred

/**
 * Created by jotaramirez on 11/3/18.
 */
class CloudDataCoroutinesStore(private val mRestApiCoroutines: ApiCoroutines) : CloudDataCoroutines {

    override fun getCityWeather(latitude: String, longitude: String): Deferred<CityWeatherEntity?> =
            mRestApiCoroutines.getCityWeather(latitude, longitude, "metric", BuildConfig.APPID)
}