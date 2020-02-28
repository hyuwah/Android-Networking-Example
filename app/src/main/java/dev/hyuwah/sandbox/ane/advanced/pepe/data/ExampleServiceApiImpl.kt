package dev.hyuwah.sandbox.ane.advanced.pepe.data

import dev.hyuwah.sandbox.ane.common.data.Constants
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ExampleServiceApiImpl : ExampleServiceApi {

    private var observers: MutableSet<Observer<List<UsersResponse>>> = HashSet()
    private val url = Constants.USERS_ENDPOINT

    override fun registerObserver(observer: Observer<List<UsersResponse>>) {
        observers.add(observer)
    }

    override fun callApi() {
        var disposable = RestClientApi.get().create(ExampleApi::class.java)
            .getUsers(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    if (result.isSuccessful) notifyObserver(result.body().orEmpty())
                },
                { error ->
                    notifyObserverError(error)
                }
            )
    }

    private fun notifyObserver(data: List<UsersResponse>) {
        observers.forEach {
            it.onNext(data)
            it.onComplete()
        }
    }

    private fun notifyObserverError(error: Throwable) {
        observers.forEach {
            it.onError(error)
        }
    }

}