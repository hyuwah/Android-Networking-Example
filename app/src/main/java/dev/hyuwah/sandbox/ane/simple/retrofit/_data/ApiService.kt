package dev.hyuwah.sandbox.ane.simple.retrofit._data

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsersCallback(): Call<List<UsersResponse>>

    @GET("users")
    suspend fun getUsersCoroutine(): Response<List<UsersResponse>>

    @GET("users")
    fun getUsersRxJava(): Single<Response<List<UsersResponse>>>

}