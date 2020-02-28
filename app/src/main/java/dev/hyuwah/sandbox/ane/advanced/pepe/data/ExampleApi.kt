package dev.hyuwah.sandbox.ane.advanced.pepe.data

import dev.hyuwah.sandbox.ane.common.data.Constants
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface ExampleApi {

    @GET
    fun getUsers(@Url url: String): Observable<Response<List<UsersResponse>>>

}

object RestClientApi {
    fun get(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}