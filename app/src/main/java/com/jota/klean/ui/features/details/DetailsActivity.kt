package com.jota.klean.ui.features.details

import android.os.Bundle
import com.jota.klean.R
import com.jota.klean.app.di.components.details.DetailsComponent
import com.jota.klean.app.di.modules.details.DetailsModule
import com.jota.klean.ui.common.BaseActivity
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.component_toolbar.*

/**
 * Created by Jota Ramirez on 13/3/18.
 */
class DetailsActivity : BaseActivity<DetailsActivity, DetailsPresenter, DetailsComponent>(), DetailsView {

    companion object {
        const val PARAM_TITLE = "titleParam"

        fun getBundle(title: String): Bundle {
            val bundle = Bundle()
            bundle.putString(PARAM_TITLE, title)
            return bundle
        }
    }

    override fun bindComponent(): DetailsComponent = mAppComponent.plus(DetailsModule())

    override fun bindLayout(): Int = R.layout.activity_details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.details_title)
        enableHomeAsUp()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        tv_title.text = intent.getStringExtra(PARAM_TITLE)
    }
}