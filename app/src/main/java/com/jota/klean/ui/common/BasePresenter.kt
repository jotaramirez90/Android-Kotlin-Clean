package com.jota.klean.ui.common

/**
 * Created by jotaramirez on 5/3/18.
 */
open class BasePresenter<V : IView> : IPresenter<V> {

    protected var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun create() {
    }

    override fun viewPrepared() {
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }
}