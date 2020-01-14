package dev.hyuwah.sandbox.ane.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.hyuwah.sandbox.ane.retrofit._data.ApiServiceFactory
import kotlinx.coroutines.launch

class RetrofitCoroutineViewModel : ViewModel() {

    private val service by lazy { ApiServiceFactory.service }

    fun loadData() {
        viewModelScope.launch {
            val result = service.getUsers()
            if (result.isSuccessful) {
                // Update UI
                val data = result.body().orEmpty()

            } else {
                // Failure State
            }
        }
    }

}