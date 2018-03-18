package com.jota.klean.repository

import com.jota.klean.domain.interactor.coroutines.ResultCoroutines
import com.jota.klean.domain.model.CityWeather
import com.jota.klean.domain.repository.Repository
import io.reactivex.Observable

/**
 * Created by Jota Ramirez on 18/3/18.
 */
open class TestRepository : Repository {

    override fun getCityWeatherCoroutines(latitude: String, longitude: String): ResultCoroutines<CityWeather> =
            ResultCoroutines.Success(
                    CityWeather(
                            arrayListOf(),
                            "",
                            0,
                            0,
                            0,
                            "",
                            0
                    )
            )

    override fun getCityWeatherRx(latitude: String, longitude: String): Observable<CityWeather> =
            Observable.create {
                CityWeather(
                        arrayListOf(),
                        "",
                        0,
                        0,
                        0,
                        "",
                        0
                )
            }
}