package com.jota.klean.domain.interactor.rx

import com.jota.klean.domain.executor.PostExecutionThread
import com.jota.klean.domain.executor.ThreadExecutor
import dagger.internal.Preconditions
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by jotaramirez on 12/3/18.
 */
abstract class UseCaseRx<T, in Params>(
        private val threadExecutor: ThreadExecutor,
        private val postExecutionThread: PostExecutionThread) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(params: Params): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: Params) {
        Preconditions.checkNotNull(observer)
        val observable: Observable<T> = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
        addDisposable(observable.subscribeWith(observer))
    }

    fun dispose() {
        if (disposables.isDisposed)
            disposables.dispose()
    }

    fun clear() {
        disposables.clear()
    }

    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }
}