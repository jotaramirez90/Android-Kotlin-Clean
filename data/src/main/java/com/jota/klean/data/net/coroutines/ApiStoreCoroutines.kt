package com.jota.klean.data.net.coroutines

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.jota.klean.data.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by jotaramirez on 11/3/18.
 */
object ApiStoreCoroutines {

    fun <T> createRetrofitService(clazz: Class<T>): T {
        val restAdapter = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(BuildConfig.API)
                .build()

        return restAdapter.create(clazz)
    }
}