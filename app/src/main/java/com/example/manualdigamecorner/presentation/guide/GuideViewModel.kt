package com.example.manualdigamecorner.presentation.guide
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.manualdigamecorner.data.Repository
import com.example.manualdigamecorner.model.SingleGuideStepResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson
import kotlinx.coroutines.launch
class GuideViewModel : ViewModel(){
    private val httpClient = HttpClient(Android){
        install(ContentNegotiation){
            gson()
        }
    }
    private val repository = Repository(
        httpClient
    )
    val guides = mutableStateListOf<SingleGuideStepResponse>()
    init {
        viewModelScope.launch {
            repository.getAllGuide().collect{
                guides.addAll(it.data.sortedBy { it.order })
            }
        }
    }
}