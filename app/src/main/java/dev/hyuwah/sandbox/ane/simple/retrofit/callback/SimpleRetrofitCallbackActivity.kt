package dev.hyuwah.sandbox.ane.simple.retrofit.callback

import android.os.Bundle
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity
import dev.hyuwah.sandbox.ane.simple.retrofit._data.ApiServiceFactory
import kotlinx.android.synthetic.main.activity_network_example.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SimpleRetrofitCallbackActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Simple Retrofit Callback"
        setupRecyclerView()

        btn_load_data.setOnClickListener { loadData() }
    }

    private fun loadData() {
        showLoading()
        ApiServiceFactory.service.getUsersCallback()
            .enqueue(object : Callback<List<UsersResponse>> {

                override fun onResponse(
                    call: Call<List<UsersResponse>>,
                    response: Response<List<UsersResponse>>
                ) {
                    onSuccess(response)
                }

                override fun onFailure(call: Call<List<UsersResponse>>, t: Throwable) {
                    onError(t)
                }

            })
    }

    private fun onSuccess(response: Response<List<UsersResponse>>) {
        hideLoading()
        if (response.isSuccessful) {
            adapter.setData(response.body() ?: listOf())
        } else {
            // Handle Error http / business logic
            showToast("HTTP Error: " + response.code().toString())
        }
    }

    private fun onError(t: Throwable) {
        hideLoading()
        // Handle Error Exception
        showToast(t.message ?: "Unknown Exception")
    }
}