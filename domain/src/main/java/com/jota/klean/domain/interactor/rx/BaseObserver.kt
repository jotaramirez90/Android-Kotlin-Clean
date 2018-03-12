package com.jota.klean.domain.interactor.rx

import io.reactivex.observers.DisposableObserver

/**
 * Created by jotaramirez on 12/3/18.
 */
open class BaseObserver<T> : DisposableObserver<T>() {

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
    }

    override fun onComplete() {
    }
}