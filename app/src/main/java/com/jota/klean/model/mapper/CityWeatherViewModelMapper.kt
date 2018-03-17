package com.jota.klean.model.mapper

import com.jota.klean.domain.model.CityWeather
import com.jota.klean.model.CityWeatherViewModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jota Ramirez on 17/3/18.
 */
@Singleton
class CityWeatherViewModelMapper @Inject constructor(
        private val weatherViewModelMapper: WeatherViewModelMapper
) {

    fun transform(model: CityWeather): CityWeatherViewModel =
            CityWeatherViewModel(
                    weatherViewModelMapper.transform(model.weather),
                    model.base,
                    model.visibility,
                    model.dt,
                    model.id,
                    model.name,
                    model.cod
            )
}