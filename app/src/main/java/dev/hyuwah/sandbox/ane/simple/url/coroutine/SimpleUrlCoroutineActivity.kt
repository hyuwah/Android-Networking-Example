package dev.hyuwah.sandbox.ane.simple.url.coroutine

import android.os.Bundle
import com.google.gson.Gson
import dev.hyuwah.sandbox.ane.common.data.Constants
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_network_example.*
import kotlinx.coroutines.*
import java.lang.Exception
import java.net.URL

class SimpleUrlCoroutineActivity : BaseActivity(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Simple URL Coroutine"
        setupRecyclerView()

        btn_load_data.setOnClickListener { loadData() }
    }

    private fun loadData() {
        showLoading()
        launch(Dispatchers.Main) {
            try {
                val userList = withContext(Dispatchers.IO) {
                    val jsonString = URL(Constants.USERS_API).readText()
                    Gson().fromJson(jsonString, Array<UsersResponse>::class.java).toList()
                }
                adapter.setData(userList)
            } catch (e: Exception) {
                // Handle error exception
            }
            hideLoading()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}
