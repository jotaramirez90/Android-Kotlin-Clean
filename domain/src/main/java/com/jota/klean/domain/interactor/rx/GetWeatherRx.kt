package com.jota.klean.domain.interactor.rx

import com.jota.klean.domain.executor.PostExecutionThread
import com.jota.klean.domain.executor.ThreadExecutor
import com.jota.klean.domain.model.CityWeather
import com.jota.klean.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jotaramirez on 12/3/18.
 */
class GetWeatherRx @Inject constructor(
        val repository: Repository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread)
    : UseCaseRx<CityWeather, GetWeatherRx.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<CityWeather> =
            repository.getCityWeatherRx(params.latitude, params.longitude)

    class Params private constructor(val longitude: String, val latitude: String) {
        companion object {
            fun forCity(longitude: String, latitude: String) = Params(longitude, latitude)
        }
    }
}