package dev.hyuwah.sandbox.ane.damnsimple

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import dev.hyuwah.sandbox.ane.R
import dev.hyuwah.sandbox.ane.common.data.Constants
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity
import dev.hyuwah.sandbox.ane.common.ui.UserAdapter
import kotlinx.android.synthetic.main.activity_network_example.*
import kotlinx.coroutines.*
import java.net.URL

class DamnSimpleActivity : BaseActivity(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_example)
        title = "Damn Simple (URL)"

        setupRecyclerView()

        btn_load_data.setOnClickListener { loadData() }
    }

    private fun loadData() {
        showLoading()
        launch(Dispatchers.Main) {
            val userList = withContext(Dispatchers.IO) {
                val jsonString = URL(Constants.API_URL).readText()
                Gson().fromJson(jsonString, Array<UsersResponse>::class.java).toList()
            }
            adapter.setData(userList)
            hideLoading()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}
