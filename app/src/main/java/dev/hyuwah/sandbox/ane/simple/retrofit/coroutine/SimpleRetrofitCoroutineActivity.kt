package dev.hyuwah.sandbox.ane.simple.retrofit.coroutine

import android.os.Bundle
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity
import dev.hyuwah.sandbox.ane.simple.retrofit._data.ApiServiceFactory
import kotlinx.android.synthetic.main.activity_network_example.*
import kotlinx.coroutines.*
import retrofit2.Response

class SimpleRetrofitCoroutineActivity : BaseActivity(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Simple Retrofit Coroutine"
        setupRecyclerView()

        btn_load_data.setOnClickListener { loadData() }
    }

    private fun loadData() {
        showLoading()
        launch(Dispatchers.IO) {
            try {
                val response = ApiServiceFactory.service.getUsersCoroutine()
                withContext(Dispatchers.Main) { onSuccess(response) }
            } catch (t: Throwable) {
                withContext(Dispatchers.Main) { onError(t) }
            }
        }
    }

    private fun onSuccess(response: Response<List<UsersResponse>>) {
        hideLoading()
        if (response.isSuccessful) {
            adapter.setData(response.body().orEmpty())
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