package com.jota.klean.features.main

import com.jota.klean.app.base.IView

/**
 * Created by jotaramirez on 5/3/18.
 */
interface MainView : IView {

    fun setCoroutines(text: String)

    fun setRx(text: String)
}