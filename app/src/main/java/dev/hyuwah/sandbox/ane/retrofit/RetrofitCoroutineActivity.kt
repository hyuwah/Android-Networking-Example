package dev.hyuwah.sandbox.ane.retrofit

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity

class RetrofitCoroutineActivity : BaseActivity() {

    lateinit var viewModel: RetrofitCoroutineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RetrofitCoroutineViewModel::class.java)
        viewModel.loadData()
    }
}