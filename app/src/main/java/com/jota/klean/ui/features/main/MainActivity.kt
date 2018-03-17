package com.jota.klean.ui.features.main

import android.os.Bundle
import com.jota.klean.R
import com.jota.klean.app.extensions.navigate
import com.jota.klean.app.internal.di.components.main.MainComponent
import com.jota.klean.app.internal.di.modules.main.MainModule
import com.jota.klean.ui.common.BaseActivity
import com.jota.klean.ui.features.details.DetailsActivity
import com.jota.klean.ui.features.main.rx.RxMainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainActivity, MainPresenter, MainComponent>(), MainView {

    override fun bindComponent(): MainComponent = mAppComponent.plus(MainModule())

    override fun bindLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_rx -> {
                    replaceFragment(R.id.fl_container, RxMainFragment.newInstance())
                    navigate<DetailsActivity>(DetailsActivity.getBundle("Rx"))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_coroutines -> {
                    navigate<DetailsActivity>(DetailsActivity.getBundle("Coroutines"))
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    override fun setCoroutines(text: String) {
        tv_coroutines.text = text
    }

    override fun setRx(text: String) {
        tv_rx.text = text
    }
}
