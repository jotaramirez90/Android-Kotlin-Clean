package com.jota.klean.ui.features.main

import android.os.Bundle
import com.jota.klean.R
import com.jota.klean.app.di.components.main.MainComponent
import com.jota.klean.app.di.modules.main.MainModule
import com.jota.klean.ui.common.BaseActivity
import com.jota.klean.ui.features.main.coroutines.CoroutinesMainFragment
import com.jota.klean.ui.features.main.rx.RxMainFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.component_toolbar.*

class MainActivity : BaseActivity<MainActivity, MainPresenter, MainComponent>(), MainView {

    override fun bindComponent(): MainComponent = mAppComponent.plus(MainModule())

    override fun bindLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.main_title)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_rx -> {
                    replaceFragment(
                            R.id.container,
                            RxMainFragment.newInstance(),
                            getString(R.string.bottom_title_rx)
                    )
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_coroutines -> {
                    replaceFragment(
                            R.id.container,
                            CoroutinesMainFragment.newInstance(),
                            getString(R.string.bottom_title_coroutines)
                    )
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }
}
