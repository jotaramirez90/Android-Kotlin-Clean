package com.jota.klean.model.mapper

import com.jota.klean.domain.model.Weather
import com.jota.klean.model.WeatherViewModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jota Ramirez on 17/3/18.
 */
@Singleton
class WeatherViewModelMapper @Inject constructor() {

    fun transform(model: Weather): WeatherViewModel =
            WeatherViewModel(
                    model.id,
                    model.main,
                    model.description,
                    model.icon
            )

    fun transform(models: List<Weather>?): List<WeatherViewModel> =
            models?.map { transform(it) } ?: arrayListOf()
}