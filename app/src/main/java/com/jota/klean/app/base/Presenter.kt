package com.jota.klean.app.base

/**
 * Created by jotaramirez on 5/3/18.
 */
open class Presenter<in V : IView> {

    private lateinit var view: V

    fun attachView(view: V) {
        this.view = view
    }

    fun create() {}

    fun resume() {}

    fun viewPrepared() {}

    fun pause() {}

    fun destroy() {}
}