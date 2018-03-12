package com.jota.klean.domain.interactor.coroutines

/**
 * Created by jotaramirez on 11/3/18.
 */
interface UseCaseCoroutines<out T, in Params> {

    fun execute(params: Params): T
}