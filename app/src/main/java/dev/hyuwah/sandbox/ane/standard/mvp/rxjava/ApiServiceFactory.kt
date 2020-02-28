package dev.hyuwah.sandbox.ane.standard.mvp.rxjava

import dev.hyuwah.sandbox.ane.common.data.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceFactory {
    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    val service by lazy { retrofit.create(ApiService::class.java) }
}