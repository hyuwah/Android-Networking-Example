package dev.hyuwah.sandbox.ane.simple.asynchttp

import android.os.Bundle
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import dev.hyuwah.sandbox.ane.common.data.Constants
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_network_example.*

class SimpleAsyncHttpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "AsyncHttp"
        setupRecyclerView()

        btn_load_data.setOnClickListener { loadData() }
    }

    private fun loadData() {
        showLoading()
        AsyncHttpClient().get(Constants.USERS_API, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                hideLoading()
                val result = String(responseBody)
                val response = Gson().fromJson(result, Array<UsersResponse>::class.java).toList()
                adapter.setData(response)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable
            ) {
                hideLoading()
                showToast("Error ${statusCode}: " + error.message)
            }

        })
    }
}