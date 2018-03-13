package com.jota.klean.domain.repository

import com.jota.klean.domain.interactor.coroutines.ResultCoroutines
import com.jota.klean.domain.model.CityWeather
import io.reactivex.Observable

/**
 * Created by jotaramirez on 11/3/18.
 */
interface Repository {

    fun getCityWeatherCoroutines(latitude: String, longitude: String): ResultCoroutines<CityWeather>

    fun getCityWeatherRx(latitude: String, longitude: String): Observable<CityWeather>
}