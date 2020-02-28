package dev.hyuwah.sandbox.ane.advanced.pepe.domain

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.advanced.pepe.data.ExampleServiceApi
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ExampleFactoryImpl @Inject constructor(private var exampleServiceApi: ExampleServiceApi) :
    ExampleFactory {

    private var observers: MutableSet<Observer<List<UsersResponse>>> = HashSet()

    private var observer = object : Observer<List<UsersResponse>> {

        override fun onComplete() {

        }

        override fun onNext(data: List<UsersResponse>) {
            notifyObserver(data)
        }

        override fun onSubscribe(d: Disposable) {

        }

        override fun onError(e: Throwable) {
            notifyObserverError(e)
        }

    }

    init {
        exampleServiceApi.registerObserver(observer)
    }

    override fun registerObserver(observer: Observer<List<UsersResponse>>) {
        observers.add(observer)
        println("[.] add +1 to observers : $observer")
        println("[.] observers after add : ${observers.size}")
    }

    override fun unregisterObserver(observer: Observer<List<UsersResponse>>) {
        observers.remove(observer)
        println("[.] remove -1 from observers : $observer")
        println("[.] observers after remove : ${observers.size}")
    }

    override fun getData() {
        exampleServiceApi.callApi()
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