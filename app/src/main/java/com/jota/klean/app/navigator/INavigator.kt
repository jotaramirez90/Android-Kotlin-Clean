package com.jota.klean.app.navigator

import android.app.Activity

/**
 * Created by Jota Ramirez on 13/3/18.
 */
interface INavigator {

    fun setActivity(activity: Activity?)

    fun navigateToDetails()
}