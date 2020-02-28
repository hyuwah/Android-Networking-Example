package dev.hyuwah.sandbox.ane.advanced.pepe.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.hyuwah.sandbox.ane.R
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.ui.UserAdapter
import kotlinx.android.synthetic.main.activity_example.*

class ExampleActivity : AppCompatActivity(), ExampleContract {

    var presenter = ExamplePresenter(this)

    private val adapter = UserAdapter {
        Toast.makeText(this, "Clicked: ${it.username}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        presenter.registerObserver()
        setupRecyclerView()
        btn_load_data.setOnClickListener {
            presenter.loadData()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unregisterObserver()
    }

    override fun showLoading() {
        progress_loading.visibility = View.VISIBLE
        rv_user_list.visibility = View.GONE
    }

    override fun hideLoading() {
        progress_loading.visibility = View.GONE
        rv_user_list.visibility = View.VISIBLE
    }

    override fun setData(data: List<UsersResponse>) {
        adapter.setData(data)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setupRecyclerView() {
        rv_user_list.layoutManager = LinearLayoutManager(this)
        rv_user_list.adapter = adapter
    }

}
