package dev.hyuwah.sandbox.ane.standard.mvp.rxjava

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class StandardMvpRxjavaPresenter(
    private var view: StandardMvpRxjavaView?
) {

    private val service = ApiServiceFactory.service
    private var disposable: Disposable? = null

    fun loadData() {
        view?._showLoading()
        disposable = service.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                view?._hideLoading()
                if (result.isSuccessful) {
                    view?.setData(result.body().orEmpty())
                } else {
                    view?._showToast(result.errorBody()?.toString().orEmpty())
                }
            }, { throwable ->
                view?._hideLoading()
                view?._showToast(throwable.message ?: "Unknown Exception")
            })
    }

    fun releaseReferences() {
        disposable?.dispose()
        view = null
    }

}