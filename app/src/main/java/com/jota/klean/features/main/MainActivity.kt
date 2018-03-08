package com.jota.klean.features.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.jota.klean.R
import com.jota.klean.app.base.BaseActivity
import com.jota.klean.app.extensions.app
import com.jota.klean.app.internal.di.modules.main.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    private val component by lazy { app.component.plus(MainModule()) }

    override fun bindLayout(): Int = R.layout.activity_main

    override fun bindPresenter() = mainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
