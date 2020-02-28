package dev.hyuwah.sandbox.ane.advanced.pepe.domain

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import io.reactivex.Observer

interface ExampleFactory {

    fun registerObserver(observer: Observer<List<UsersResponse>>)
    fun unregisterObserver(observer: Observer<List<UsersResponse>>)
    fun getData()

}