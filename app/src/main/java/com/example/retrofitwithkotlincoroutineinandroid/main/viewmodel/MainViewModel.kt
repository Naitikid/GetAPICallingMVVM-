package com.example.loginusingmvvm.signup.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.loginusingmvvm.network.RetrofitClient
import com.example.loginusingmvvm.network.Service
import com.example.loginusingmvvm.signup.repository.MainRepository
import com.example.loginusingmvvm.util.*
import com.example.retrofitwithkotlincoroutineinandroid.main.model.MainModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(application: Application) : AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext


    var responseCodeCheck: ResponseCodeCheck = ResponseCodeCheck()
    private var mutableLiveData: MutableLiveData<Resource<MainModel>> = MutableLiveData()
    var liveData: LiveData<Resource<MainModel>> = mutableLiveData

    fun sendDataInRetrofit() {
        mutableLiveData.value = Resource.loading(null)
        val apiInterface = RetrofitClient.getRetrofit().create(Service::class.java)
        val mainRepository  = MainRepository(apiInterface)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository : Response<MainModel> = mainRepository.senData()
                mutableLiveData.postValue(responseCodeCheck.getResponseResult(repository))
            }catch (e:Exception){
                Log.e("TAG", "sendDataInRetrofit: "+e.message)
                mutableLiveData.postValue(Resource.error(e.message!!, null))
            }
        }
    }


}