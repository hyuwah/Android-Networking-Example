package dev.hyuwah.sandbox.ane.simple.retrofit._data

import dev.hyuwah.sandbox.ane.common.data.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceFactory {

    //== Callback & Coroutine
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    val service: ApiService = retrofit.create(ApiService::class.java)

    //== RxJava
    private val retrofitRx = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    val serviceRx: ApiService = retrofitRx.create(ApiService::class.java)

}