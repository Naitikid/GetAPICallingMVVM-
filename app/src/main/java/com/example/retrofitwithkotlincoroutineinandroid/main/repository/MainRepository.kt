package com.example.loginusingmvvm.signup.repository

import com.example.loginusingmvvm.network.Service
import com.example.retrofitwithkotlincoroutineinandroid.main.model.MainModel
import retrofit2.Response

class MainRepository constructor(private val service: Service){
    suspend fun senData():Response<MainModel>{
        return service.getQuotes()
    }
}