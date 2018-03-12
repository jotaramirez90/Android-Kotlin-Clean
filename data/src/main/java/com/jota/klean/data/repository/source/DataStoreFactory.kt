package com.jota.klean.data.repository.source

import com.jota.klean.data.net.coroutines.ApiCoroutines
import com.jota.klean.data.net.coroutines.ApiStoreCoroutines
import com.jota.klean.data.net.rx.ApiRx
import com.jota.klean.data.net.rx.ApiStoreRx
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by jotaramirez on 11/3/18.
 */
@Singleton
class DataStoreFactory @Inject constructor() {

    fun createCloudDataCoroutines(): CloudDataCoroutines {
        val apiCoroutines: ApiCoroutines = ApiStoreCoroutines.createRetrofitService(ApiCoroutines::class.java)
        return CloudDataCoroutinesStore(apiCoroutines)
    }

    fun createCloudDataRx(): CloudDataRx {
        val apiRx: ApiRx = ApiStoreRx.createRetrofitService(ApiRx::class.java)
        return CloudDataRxStore(apiRx)
    }
}