package com.example.loginusingmvvm.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun getRetrofit(): Retrofit {
        val baseUrl = "https://dl.dropboxusercontent.com/s/p57gxwqm84zkp96/"
        val okHttpClient = OkHttpClient.Builder()
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}