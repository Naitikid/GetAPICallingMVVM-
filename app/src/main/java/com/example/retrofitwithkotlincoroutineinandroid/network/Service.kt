package com.example.loginusingmvvm.network

import com.example.retrofitwithkotlincoroutineinandroid.main.model.MainModel
import retrofit2.Response
import retrofit2.http.*

interface Service {
    @GET("demo_api.json")
    suspend fun getQuotes() : Response<MainModel>
}