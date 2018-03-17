package com.jota.klean.domain.interactor.coroutines

/**
 * Created by Jota Ramirez on 13/3/18.
 */
sealed class ResultCoroutines<out T> {

    class Success<out T : Any>(val data: T) : ResultCoroutines<T>()

    class Error(val exception: Throwable) : ResultCoroutines<Nothing>()
}