package com.jota.klean.ui.features.main

import com.jota.klean.ui.common.BasePresenter
import com.jota.klean.domain.interactor.coroutines.GetWeatherCoroutines
import com.jota.klean.domain.interactor.coroutines.ResultCoroutines
import com.jota.klean.domain.interactor.rx.BaseObserver
import com.jota.klean.domain.interactor.rx.GetWeatherRx
import com.jota.klean.domain.model.CityWeather
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

/**
 * Created by jotaramirez on 7/3/18.
 */
class MainPresenter(private val getWeatherCoroutines: GetWeatherCoroutines,
                    private val getWeatherRx: GetWeatherRx
) : BasePresenter<MainView>() {

    override fun create() {
        super.create()
        getDataCoroutines()
        getDataRx()
    }

    private fun getDataCoroutines() {
        async(UI) {
            val result = bg {
                getWeatherCoroutines.execute(
                        GetWeatherCoroutines.Params.forCity("-4.3055249", "39.8073556"))
            }
            val data = result.await()
            view?.setCoroutines(when (data) {
                is ResultCoroutines.Success -> "Coroutines: " + data.data.name!!
                is ResultCoroutines.Error -> "Coroutines: Error"
            })
        }
    }

    private fun getDataRx() {
        getWeatherRx.execute(
                GetWeatherRxObserver(),
                GetWeatherRx.Params.forCity("-4.3055249", "39.8073556")
        )
    }

    inner class GetWeatherRxObserver : BaseObserver<CityWeather>() {
        override fun onNext(t: CityWeather) {
            super.onNext(t)
            view?.setRx("Rx: " + t.name!!)
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            view?.setRx("Rx: Error")
        }
    }
}