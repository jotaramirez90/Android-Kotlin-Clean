package com.jota.klean.ui.features.main

import com.jota.klean.ui.common.IView

/**
 * Created by jotaramirez on 5/3/18.
 */
interface MainView : IView {

    fun setCoroutines(text: String)

    fun setRx(text: String)
}