package com.jota.klean.app.navigator

import android.app.Activity
import android.content.Intent
import com.jota.klean.features.details.DetailsActivity
import javax.inject.Inject

/**
 * Created by Jota Ramirez on 13/3/18.
 */
class Navigator @Inject constructor() : INavigator {

    private var mActivity: Activity? = null

    override fun setActivity(activity: Activity?) {
        mActivity = activity
    }

    private fun launch(intent: Intent) {
        mActivity?.startActivity(intent)
    }

    private fun launchForResult(intent: Intent, code: Int) {
        mActivity?.startActivityForResult(intent, code)
    }

    override fun navigateToDetails() {
        launch(DetailsActivity.getCallingIntent(mActivity))
    }
}