package dev.hyuwah.sandbox.ane.simple.retrofit.rxjava

import android.os.Bundle
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.ui.BaseActivity
import dev.hyuwah.sandbox.ane.simple.retrofit._data.ApiServiceFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_network_example.*
import retrofit2.Response

class SimpleRetrofitRxJavaActivity : BaseActivity() {

    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Simple Retrofit RxJava"
        setupRecyclerView()

        btn_load_data.setOnClickListener { loadData() }
    }

    private fun loadData() {
        showLoading()

        val disposable = ApiServiceFactory.serviceRx.getUsersRxJava()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                onSuccess(response)
            }, { throwable ->
                onError(throwable)
            })
        compositeDisposable.add(disposable)
    }

    private fun onSuccess(response: Response<List<UsersResponse>>) {
        hideLoading()
        if (response.isSuccessful) {
            adapter.setData(response.body() ?: listOf())
        }
        // Handle Error http / business logic
    }

    private fun onError(t: Throwable) {
        hideLoading()
        // Handle Error Exception
        showToast(t.message ?: "Unknown Exception")
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

}