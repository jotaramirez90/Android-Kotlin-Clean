package com.jota.klean.ui.features.main.rx

import com.jota.klean.model.CityWeatherViewModel
import com.jota.klean.ui.common.IView

/**
 * Created by Jota Ramirez on 16/3/18.
 */
interface RxMainView : IView {

    fun setData(data: CityWeatherViewModel)

    fun setError(error: String)
}