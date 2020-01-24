package dev.hyuwah.sandbox.ane.advanced.coroutine.data

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.domain.Result
import dev.hyuwah.sandbox.ane.advanced.coroutine.domain.Repository

class RepositoryImpl(private val service: ApiService) : Repository {

    override suspend fun getUsers(): Result<List<UsersResponse>> {
        return try {
            val result = service.getUsers()
            if (result.isSuccessful) {
                Result.Success(result.body().orEmpty())
            } else {
                Result.Error(Exception("HTTP Error: " + result.code().toString()))
            }
        } catch (t: Throwable) {
            Result.Error(Exception(t.message ?: "Unknown Exception"))
        }
    }

}