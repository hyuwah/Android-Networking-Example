package dev.hyuwah.sandbox.ane.standard.mvp.rxjava

import android.os.Bundle
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_network_example.*

class StandardMvpRxjavaActivity : BaseActivity(), StandardMvpRxjavaView {

    private val presenter = StandardMvpRxjavaPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        btn_load_data.setOnClickListener {
            presenter.loadData()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.releaseReferences()
    }

    override fun setData(data: List<UsersResponse>) {
        adapter.setData(data)
    }

    override fun _showLoading() {
        showLoading()
    }

    override fun _hideLoading() {
        hideLoading()
    }

    override fun _showToast(message: String) {
        showToast(message)
    }
}