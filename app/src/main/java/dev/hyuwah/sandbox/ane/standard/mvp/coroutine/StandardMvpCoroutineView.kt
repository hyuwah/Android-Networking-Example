package dev.hyuwah.sandbox.ane.standard.mvp.coroutine

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse

interface StandardMvpCoroutineView {
    fun setData(data: List<UsersResponse>)
    fun _showLoading()
    fun _hideLoading()
    fun _showToast(message: String)
}