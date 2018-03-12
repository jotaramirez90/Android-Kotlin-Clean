package com.jota.klean.domain.interactor.coroutines

import com.jota.klean.domain.model.CityWeather
import com.jota.klean.domain.repository.Repository

/**
 * Created by jotaramirez on 12/3/18.
 */
class GetWeatherCoroutines(val repository: Repository) : UseCaseCoroutines<CityWeather?, GetWeatherCoroutines.Params> {

    override fun execute(params: Params): CityWeather? =
            repository.getCityWeatherCoroutines(params.longitude, params.latitude).getCompleted()

    class Params private constructor(val longitude: String, val latitude: String) {
        companion object {
            fun forCity(longitude: String, latitude: String) = Params(longitude, latitude)
        }
    }
}