package com.jota.klean.ui.features.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.jota.klean.R
import com.jota.klean.app.internal.di.components.main.MainComponent
import com.jota.klean.app.internal.di.modules.main.MainModule
import com.jota.klean.ui.common.BaseActivity
import com.jota.klean.ui.features.main.fragment.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainActivity, MainPresenter, MainComponent>(), MainView {

    override fun bindComponent(): MainComponent = mAppComponent.plus(MainModule())

    override fun bindLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                replaceFragment(R.id.fl_container, MainFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mNavigator.navigateToDetails()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun setCoroutines(text: String) {
        tv_coroutines.text = text
    }

    override fun setRx(text: String) {
        tv_rx.text = text
    }
}
