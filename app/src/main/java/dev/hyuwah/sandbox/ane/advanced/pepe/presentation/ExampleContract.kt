package dev.hyuwah.sandbox.ane.advanced.pepe.presentation

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse

interface ExampleContract {
    fun showLoading()
    fun hideLoading()
    fun setData(data: List<UsersResponse>)
    fun showToast(message: String)
}