package dev.hyuwah.sandbox.ane.common.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dev.hyuwah.sandbox.ane.R
import kotlinx.android.synthetic.main.activity_network_example.*

abstract class BaseActivity: AppCompatActivity() {

    protected val adapter = UserAdapter {
        Toast.makeText(this, "Clicked: ${it.username}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_example)
    }

    protected fun setupRecyclerView(){
        rv_user_list.layoutManager = LinearLayoutManager(this)
        rv_user_list.adapter = adapter
    }

    protected fun showLoading(){
        progress_loading.visibility = View.VISIBLE
        rv_user_list.visibility = View.GONE
    }

    protected fun hideLoading(){
        progress_loading.visibility = View.GONE
        rv_user_list.visibility = View.VISIBLE
    }

}