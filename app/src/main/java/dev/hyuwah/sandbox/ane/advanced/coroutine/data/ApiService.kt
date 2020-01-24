package dev.hyuwah.sandbox.ane.advanced.coroutine.data

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<UsersResponse>>

}