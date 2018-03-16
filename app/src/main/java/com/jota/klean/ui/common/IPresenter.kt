package com.jota.klean.ui.common

/**
 * Created by jotaramirez on 8/3/18.
 */
interface IPresenter<in T : IView> {

    fun attachView(view: T)

    fun create()

    fun viewPrepared()

    fun resume()

    fun pause()

    fun destroy()
}