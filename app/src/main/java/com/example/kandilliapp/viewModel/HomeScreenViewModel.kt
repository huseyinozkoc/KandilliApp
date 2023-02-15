package com.example.kandilliapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kandilliapp.model.Response
import com.example.kandilliapp.network.ApiService
import kotlinx.coroutines.launch
import java.util.*

class HomeScreenViewModel : ViewModel() {
    init {
        getEarthquakeList()
    }

    var earthquakeListResponse:Response by mutableStateOf(Response("",1, listOf(),1,false))
    var errorMessage: Boolean by mutableStateOf(false)
    var isRefreshing: Boolean by mutableStateOf(false)

    fun getEarthquakeList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val earthquakeList = apiService.getEarthquakes()
                earthquakeListResponse = earthquakeList
            }
            catch (e: Exception) {
                errorMessage = true
            }
        }
    }
}