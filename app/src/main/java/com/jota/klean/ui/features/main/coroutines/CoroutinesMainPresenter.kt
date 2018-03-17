package com.jota.klean.ui.features.main.coroutines

import com.jota.klean.domain.interactor.coroutines.GetWeatherCoroutines
import com.jota.klean.domain.interactor.coroutines.ResultCoroutines
import com.jota.klean.ui.common.BasePresenter
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

/**
 * Created by Jota Ramirez on 17/3/18.
 */
class CoroutinesMainPresenter(
        private val getWeatherCoroutines: GetWeatherCoroutines
) : BasePresenter<CoroutinesMainView>() {

    private var mJobs: MutableList<Job?> = mutableListOf()

    override fun create() {
        super.create()
        mJobs.add(getDataCoroutines())
    }

    override fun destroy() {
        super.destroy()
        for (job in mJobs) {
            job?.cancel()
        }
    }

    private fun getDataCoroutines() = async(UI) {
        val result = bg {
            getWeatherCoroutines.execute(
                    GetWeatherCoroutines.Params.forCity("-4.3055249", "39.8073556")
            )
        }
        val data = result.await()
        view?.setData(when (data) {
            is ResultCoroutines.Success -> "Coroutines: " + data.data.name!!
            is ResultCoroutines.Error -> "Coroutines: Error"
        })
    }
}