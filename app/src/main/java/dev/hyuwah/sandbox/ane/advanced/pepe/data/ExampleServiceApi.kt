package dev.hyuwah.sandbox.ane.advanced.pepe.data

import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import io.reactivex.Observer

interface ExampleServiceApi {

    fun registerObserver(singleObserver: Observer<List<UsersResponse>>)
    fun callApi()

}