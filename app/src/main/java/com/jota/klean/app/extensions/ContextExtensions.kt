package com.jota.klean.app.extensions

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import com.jota.klean.App

/**
 * Created by jotaramirez on 8/3/18.
 */
val Activity.app: App
    get() = application as App

inline fun <reified T : Activity> Activity.navigate(bundle: Bundle?) {
    val intent = Intent(this, T::class.java)
    bundle?.let {
        intent.putExtras(bundle)
    }
    ActivityCompat.startActivity(this, intent, null)
}

inline fun <reified T : Activity> Activity.navigateForResult(bundle: Bundle?, code: Int) {
    val intent = Intent(this, T::class.java)
    bundle?.let {
        intent.putExtras(bundle)
    }
    ActivityCompat.startActivityForResult(this, intent, code, null)
}