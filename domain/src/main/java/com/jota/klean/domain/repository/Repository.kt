package com.jota.klean.domain.repository

import com.jota.klean.domain.model.CityWeather
import io.reactivex.Observable
import kotlinx.coroutines.experimental.Deferred

/**
 * Created by jotaramirez on 11/3/18.
 */
interface Repository {

    fun getCityWeatherCoroutines(latitude: String, longitude: String): Deferred<CityWeather>

    fun getCityWeatherRx(latitude: String, longitude: String): Observable<CityWeather>
}