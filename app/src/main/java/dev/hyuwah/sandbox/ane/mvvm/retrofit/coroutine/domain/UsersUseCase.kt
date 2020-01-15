package dev.hyuwah.sandbox.ane.mvvm.retrofit.coroutine.domain

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.domain.Result

class UsersUseCase(
    private val repository: Repository
) {

    suspend fun execute(): Result<List<UsersResponse>> {
        return repository.getUsers()
    }

}