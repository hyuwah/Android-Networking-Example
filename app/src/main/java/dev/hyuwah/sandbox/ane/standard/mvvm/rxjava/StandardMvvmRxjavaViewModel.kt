package dev.hyuwah.sandbox.ane.standard.mvvm.rxjava

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class StandardMvvmRxjavaViewModel : ViewModel() {

    private val service = ApiServiceFactory.service
    private var disposable: Disposable? = null

    private val _userList = MutableLiveData<List<UsersResponse>>(mutableListOf())
    val userList = _userList as LiveData<List<UsersResponse>>

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage = _errorMessage as LiveData<String>

    fun loadData() {
        disposable = service.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                if (result.isSuccessful) {
                    _userList.value = result.body().orEmpty()
                } else {
                    _errorMessage.value = result.errorBody()?.toString().orEmpty()
                }
            }, { throwable ->
                _errorMessage.value = throwable.message ?: "Unknown Exception"
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}