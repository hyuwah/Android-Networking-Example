package dev.hyuwah.sandbox.ane.standard.mvvm.coroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StandardMvvmCoroutineViewModel : ViewModel() {

    private val service = ApiServiceFactory.service

    private val _userList = MutableLiveData<List<UsersResponse>>(mutableListOf())
    val userList = _userList as LiveData<List<UsersResponse>>

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage = _errorMessage as LiveData<String>

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = service.getUsers()
                withContext(Dispatchers.Main) {
                    if (result.isSuccessful) {
                        _userList.value = result.body().orEmpty()
                    } else {
                        _errorMessage.value = result.errorBody()?.toString().orEmpty()
                    }
                }
            } catch (t: Throwable) {
                _errorMessage.postValue(t.message ?: "Unknown Exception")
            }
        }
    }

}