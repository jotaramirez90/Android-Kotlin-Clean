package com.jota.klean.features.details

import android.app.Activity
import android.content.Intent
import com.jota.klean.R
import com.jota.klean.app.base.BaseActivity
import com.jota.klean.app.extensions.app
import com.jota.klean.app.internal.di.components.details.DetailsComponent
import com.jota.klean.app.internal.di.modules.details.DetailsModule

/**
 * Created by Jota Ramirez on 13/3/18.
 */
class DetailsActivity : BaseActivity<DetailsActivity, DetailsPresenter, DetailsComponent>(), DetailsView {

    companion object {

        fun getCallingIntent(activity: Activity?): Intent =
                Intent(activity, DetailsActivity::class.java)
    }

    override fun bindComponent(): DetailsComponent = app.component.plus(DetailsModule())

    override fun bindLayout(): Int = R.layout.activity_details
}