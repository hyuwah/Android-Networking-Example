package dev.hyuwah.sandbox.ane.mvvm.retrofit.coroutine.presentation

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity

class RetrofitCoroutineActivity : BaseActivity() {

    lateinit var viewModel: RetrofitCoroutineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RetrofitCoroutineViewModel::class.java)
        viewModel.userList.observe(this, userListObserver)
        showLoading()
        viewModel.loadData()
    }

    private val userListObserver = Observer<List<UsersResponse>> {
        hideLoading()
        adapter.setData(it)
    }

}