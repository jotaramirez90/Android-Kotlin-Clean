package com.jota.klean.app.base

/**
 * Created by jotaramirez on 8/3/18.
 */
interface Presenter<in T : IView> {

    fun attachView(view: T)

    fun create()

    fun resume()

    fun viewPrepared()

    fun pause()

    fun destroy()
}