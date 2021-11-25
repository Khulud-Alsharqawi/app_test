package com.example.app_test.overview


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_test.network.countriseApi
import kotlinx.coroutines.launch


class OverviewViewModel : ViewModel() {

    private val _status =  MutableLiveData<String>()

    val status: LiveData<String> = _status
    init {
        getCountriesImag()
    }

    private fun getCountriesImag() {
        viewModelScope.launch {
            try {
                val listResult = countriseApi.retrofitService.getImag()
                _status.value = "Success: ${listResult.data.size} photos retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}