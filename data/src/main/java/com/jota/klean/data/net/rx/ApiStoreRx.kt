package com.jota.klean.data.net.rx

import com.jota.klean.data.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by jotaramirez on 12/3/18.
 */
object ApiStoreRx {

    fun <T> createRetrofitService(clazz: Class<T>): T {
        val restAdapter = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.API)
                .build()

        return restAdapter.create(clazz)
    }
}