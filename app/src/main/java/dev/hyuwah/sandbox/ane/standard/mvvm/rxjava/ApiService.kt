package dev.hyuwah.sandbox.ane.standard.mvvm.rxjava

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Single<Response<List<UsersResponse>>>

}