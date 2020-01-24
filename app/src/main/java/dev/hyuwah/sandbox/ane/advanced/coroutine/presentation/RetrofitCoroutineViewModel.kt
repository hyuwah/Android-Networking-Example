package dev.hyuwah.sandbox.ane.advanced.coroutine.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.hyuwah.sandbox.ane.common.data.response.UsersResponse
import dev.hyuwah.sandbox.ane.common.domain.Result
import dev.hyuwah.sandbox.ane.advanced.coroutine.data.ApiServiceFactory
import dev.hyuwah.sandbox.ane.advanced.coroutine.data.RepositoryImpl
import dev.hyuwah.sandbox.ane.advanced.coroutine.domain.UsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class RetrofitCoroutineViewModel : ViewModel() {

    private val service by lazy { ApiServiceFactory.service }
    private val repository by lazy { RepositoryImpl(service) }
    private val useCase by lazy { UsersUseCase(repository) }

    private val _userList = MutableLiveData<List<UsersResponse>>(mutableListOf())
    val userList = _userList as LiveData<List<UsersResponse>>

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage = _errorMessage as LiveData<String>

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = useCase.execute()
            withContext(Dispatchers.Main) {
                when (result) {
                    is Result.Success -> setData(result.data)
                    is Result.Error -> handleError(result.exception)
                }
            }
        }
    }

    private fun setData(list: List<UsersResponse>) {
        _userList.value = list
    }

    private fun handleError(exception: Exception) {
        _errorMessage.value = exception.message
    }

}