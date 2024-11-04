package com.example.manualdigamecorner.model

data class ApiResponseWrapper<T>(
    val message: String,
    val data: T
)
