package dev.hyuwah.sandbox.ane.mvvm.retrofit.coroutine.domain

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.domain.Result

interface Repository {

    suspend fun getUsers(): Result<List<UsersResponse>>

}