package com.example.manualdigamecorner.presentation.devices
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.manualdigamecorner.data.Repository
import com.example.manualdigamecorner.model.SingleDeviceResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson
import kotlinx.coroutines.launch
class DeviceViewModel : ViewModel() {
    private val httpClient = HttpClient(Android){
        install(ContentNegotiation){
            gson()
        }
    }
    private val repository = Repository(
        httpClient
    )
    val deviceTitle = repository.getDeviceTitle()
    val devices = mutableStateListOf<SingleDeviceResponse>()
    val shownDeviceId = mutableStateOf("")
    init {
        viewModelScope.launch {
            repository.getAllDevice().collect{
                devices.addAll(it.data)
            }
        }
    }
}