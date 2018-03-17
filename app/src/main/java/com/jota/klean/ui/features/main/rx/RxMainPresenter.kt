package com.jota.klean.ui.features.main.rx

import com.jota.klean.domain.interactor.rx.BaseObserver
import com.jota.klean.domain.interactor.rx.GetWeatherRx
import com.jota.klean.domain.model.CityWeather
import com.jota.klean.model.mapper.CityWeatherViewModelMapper
import com.jota.klean.ui.common.BasePresenter

/**
 * Created by Jota Ramirez on 16/3/18.
 */
class RxMainPresenter(
        private val getWeatherRx: GetWeatherRx,
        private val cityWeatherViewModelMapper: CityWeatherViewModelMapper
) : BasePresenter<RxMainView>() {

    override fun create() {
        super.create()
        getDataRx()
    }

    override fun destroy() {
        super.destroy()
        getWeatherRx.dispose()
    }

    private fun getDataRx() {
        getWeatherRx.execute(
                GetWeatherRxObserver(),
                GetWeatherRx.Params.forCity("-4.3055249", "39.8073556")
        )
    }

    inner class GetWeatherRxObserver : BaseObserver<CityWeather>() {
        override fun onNext(data: CityWeather) {
            super.onNext(data)
            view?.setData(cityWeatherViewModelMapper.transform(data))
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            view?.setError("Rx: Error")
        }
    }
}