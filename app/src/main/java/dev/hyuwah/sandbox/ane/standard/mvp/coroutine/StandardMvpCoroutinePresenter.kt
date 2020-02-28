package dev.hyuwah.sandbox.ane.standard.mvp.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class StandardMvpCoroutinePresenter(
    private var view: StandardMvpCoroutineView?
) : CoroutineScope {

    private val service = ApiServiceFactory.service

    private var job: Job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    fun loadData() {
        view?._showLoading()
        launch {
            try {
                val result = service.getUsers()
                withContext(Dispatchers.Main) {
                    view?._hideLoading()
                    if (result.isSuccessful) {
                        view?.setData(result.body().orEmpty())
                    } else {
                        view?._showToast(result.errorBody()?.toString().orEmpty())
                    }
                }

            } catch (t: Throwable) {
                withContext(Dispatchers.Main) {
                    view?._hideLoading()
                    view?._showToast(t.message ?: "Unknown Exception")
                }
            }
        }
    }

    fun releaseReferences() {
        job.cancel()
        view = null
    }


}