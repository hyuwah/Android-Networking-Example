package dev.hyuwah.sandbox.ane.mvvm.retrofit.coroutine.data

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.domain.Result
import dev.hyuwah.sandbox.ane.mvvm.retrofit.coroutine.domain.Repository

class RepositoryImpl(private val service: ApiService) : Repository {

    override suspend fun getUsers(): Result<List<UsersResponse>> {
        val result = service.getUsers()
        return if (result.isSuccessful) {
            Result.Success(result.body().orEmpty())
        } else {
            Result.Error(Exception("HTTP Error: " + result.code().toString()))
        }
    }

}