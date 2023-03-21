package com.example.retrofitwithkotlincoroutineinandroid.main.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginusingmvvm.signup.viewmodel.MainViewModel
import com.example.loginusingmvvm.util.Status
import com.example.retrofitwithkotlincoroutineinandroid.main.adapter.MainAdapter
import com.example.retrofitwithkotlincoroutineinandroid.R
import com.example.retrofitwithkotlincoroutineinandroid.show.activity.ShowDataActivity
import com.example.retrofitwithkotlincoroutineinandroid.databinding.ActivityMainBinding
import com.example.retrofitwithkotlincoroutineinandroid.main.model.MainModel

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    companion object {
        var grpList = ArrayList<MainModel.ResultX>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.sendDataInRetrofit()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        mainViewModel.liveData.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.recyclerviewid.layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = MainAdapter(this@MainActivity, it.data!!.Result) { position ->
                        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show()
                        grpList.addAll(it.data.Result)
                        val intent = Intent(this, ShowDataActivity::class.java)
                        intent.putExtra("POSITION", position)
                        startActivity(intent)
                    }
                    binding.recyclerviewid.adapter = adapter

                    Log.e("TAG", "Status.Success" + Status.SUCCESS)
                }
                Status.LOADING -> {

                    Log.e("TAG", "Status.LOADING")
                }
                Status.ERROR -> {
                    Log.e("TAG", "Status.ERROR")
                }
            }
        }
    }
}