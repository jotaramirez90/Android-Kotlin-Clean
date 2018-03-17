package com.jota.klean.ui.features.main.coroutines

import com.jota.klean.domain.interactor.coroutines.GetWeatherCoroutines
import com.jota.klean.domain.interactor.coroutines.ResultCoroutines
import com.jota.klean.model.mapper.CityWeatherViewModelMapper
import com.jota.klean.ui.common.BasePresenter
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

/**
 * Created by Jota Ramirez on 17/3/18.
 */
class CoroutinesMainPresenter(
        private val getWeatherCoroutines: GetWeatherCoroutines,
        private val cityWeatherViewModelMapper: CityWeatherViewModelMapper
) : BasePresenter<CoroutinesMainView>() {

    override fun create() {
        super.create()
        getDataCoroutines()
    }

    override fun destroy() {
        super.destroy()
        getWeatherCoroutines.dispose()
    }

    private fun getDataCoroutines() = async(UI) {
        val result =
                getWeatherCoroutines.execute(
                        GetWeatherCoroutines.Params.forCity("-4.3055249", "39.8073556")
                )
        (when (result) {
            is ResultCoroutines.Success ->
                view?.setData(cityWeatherViewModelMapper.transform(result.data))
            is ResultCoroutines.Error ->
                view?.setError("Coroutines: Error")
        })
    }
}