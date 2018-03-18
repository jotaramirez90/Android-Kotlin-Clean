package com.jota.klean.ui.common

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.jota.klean.R


/**
 * Created by Jota Ramirez on 18/3/18.
 */
@VisibleForTesting
class TestActivity : AppCompatActivity() {
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frameLayout = FrameLayout(this)
        frameLayout.id = R.id.container
        setContentView(frameLayout)
    }
}