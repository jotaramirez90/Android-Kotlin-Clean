package com.jota.klean.app.extensions

import android.app.Activity
import com.jota.klean.App

/**
 * Created by jotaramirez on 8/3/18.
 */
val Activity.app: App
    get() = application as App