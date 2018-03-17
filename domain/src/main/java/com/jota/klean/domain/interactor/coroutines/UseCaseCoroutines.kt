package com.jota.klean.domain.interactor.coroutines

import dagger.internal.Preconditions
import kotlinx.coroutines.experimental.Deferred
import org.jetbrains.anko.coroutines.experimental.bg

/**
 * Created by jotaramirez on 11/3/18.
 */
abstract class UseCaseCoroutines<out T : Any, in Params> {

    private val disposables: MutableList<Deferred<ResultCoroutines<T>>> = mutableListOf()

    abstract fun buildUseCaseObservable(params: Params): ResultCoroutines<T>

    suspend fun execute(params: Params): ResultCoroutines<T> {
        val result = bg {
            buildUseCaseObservable(params)
        }
        addDisposable(result)
        return result.await()
    }

    fun dispose() {
        disposables.forEach { it.cancel() }
    }

    fun clear() {
        disposables.clear()
    }

    private fun addDisposable(disposable: Deferred<ResultCoroutines<T>>) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }
}