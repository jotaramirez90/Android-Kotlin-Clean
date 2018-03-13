package com.jota.klean.data.repository.source

import com.jota.klean.data.entity.CityWeatherEntity
import kotlinx.coroutines.experimental.Deferred

/**
 * Created by jotaramirez on 11/3/18.
 */
interface CloudDataCoroutines {

    fun getCityWeather(latitude: String, longitude: String): Deferred<CityWeatherEntity?>
}