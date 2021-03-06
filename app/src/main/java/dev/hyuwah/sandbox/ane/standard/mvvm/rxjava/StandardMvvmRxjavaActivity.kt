package dev.hyuwah.sandbox.ane.standard.mvvm.rxjava

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_network_example.*

class StandardMvvmRxjavaActivity : BaseActivity() {

    lateinit var viewModel: StandardMvvmRxjavaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        viewModel = ViewModelProvider(this).get(StandardMvvmRxjavaViewModel::class.java)
        viewModel.userList.observe(this, userListObserver)
        viewModel.errorMessage.observe(this, errorMessageObserver)
        btn_load_data.setOnClickListener {
            showLoading()
            viewModel.loadData()
        }
    }

    private val userListObserver = Observer<List<UsersResponse>> {
        hideLoading()
        adapter.setData(it)
    }

    private val errorMessageObserver = Observer<String> {
        hideLoading()
        showToast(it)
    }
}