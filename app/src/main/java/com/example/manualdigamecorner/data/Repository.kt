package com.example.manualdigamecorner.data
import com.example.manualdigamecorner.model.ApiResponseWrapper
import com.example.manualdigamecorner.model.SingleDeviceResponse
import com.example.manualdigamecorner.model.SingleGuideStepResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.flow
class Repository (
    private val client: HttpClient
) {
    fun getAllGuide() = flow {
        val res = client.get("https://my-json-server.typicode.com/fahmigutawan/FakeDB-GameCorner/guide")
        if(res.status == HttpStatusCode.OK){
            val body = res.body<ApiResponseWrapper<List<SingleGuideStepResponse>>>()
            emit(body)
        }
    }
    fun getAllDevice() = flow {
        val res = client.get("https://my-json-server.typicode.com/fahmigutawan/FakeDB-GameCorner/device")
        if(res.status == HttpStatusCode.OK){
            val body = res.body<ApiResponseWrapper<List<SingleDeviceResponse>>>()
            emit(body)
        }
    }
}