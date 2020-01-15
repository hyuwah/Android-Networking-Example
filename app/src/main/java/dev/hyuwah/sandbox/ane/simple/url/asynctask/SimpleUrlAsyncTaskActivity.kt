package dev.hyuwah.sandbox.ane.simple.url.asynctask

import android.os.Bundle
import dev.hyuwah.sandbox.ane.common.data.Constants
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_network_example.*

class SimpleUrlAsyncTaskActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Simple URL AsyncTask"
        setupRecyclerView()

        btn_load_data.setOnClickListener { loadData() }
    }

    private fun loadData() {
        showLoading()
        GetUsersTask {
            hideLoading()
            adapter.setData(it)
        }.execute(Constants.USERS_API)
    }
}