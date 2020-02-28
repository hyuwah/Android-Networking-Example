package dev.hyuwah.sandbox.ane.advanced.pepe.presentation

import dev.hyuwah.sandbox.ane.ExampleApp
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.advanced.pepe.domain.ExampleFactory
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ExamplePresenter(private var viewContract: ExampleContract?) {

    @Inject
    lateinit var exampleFactory: ExampleFactory

    private var exampleObserver = object : Observer<List<UsersResponse>> {
        override fun onComplete() {

        }

        override fun onNext(data: List<UsersResponse>) {
            viewContract?.hideLoading()
            viewContract?.setData(data)
        }

        override fun onSubscribe(d: Disposable) {

        }

        override fun onError(e: Throwable) {
            viewContract?.hideLoading()
            viewContract?.showToast(e.message ?: "Unknown Error")
        }

    }

    init {
        ExampleApp.getDaggerComponent().inject(this)
    }

    fun registerObserver() {
        exampleFactory.registerObserver(exampleObserver)
    }

    fun unregisterObserver() {
        exampleFactory.unregisterObserver(exampleObserver)
    }

    fun loadData() {
        viewContract?.showLoading()
        exampleFactory.getData()
    }


}