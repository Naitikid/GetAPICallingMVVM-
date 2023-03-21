package com.example.retrofitwithkotlincoroutineinandroid.show.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.retrofitwithkotlincoroutineinandroid.R
import com.example.retrofitwithkotlincoroutineinandroid.main.activity.MainActivity.Companion.grpList
import com.example.retrofitwithkotlincoroutineinandroid.databinding.ActivityShowDataBinding
import com.example.retrofitwithkotlincoroutineinandroid.show.fragment.ShowFragment

class ShowDataActivity : AppCompatActivity() {
    lateinit var binding:ActivityShowDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_data)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(false)

        val position = intent.getIntExtra("POSITION",0)
        supportActionBar!!.setTitle(grpList[position].Title)

        val bundle = Bundle()
        bundle.putInt("POSITION",position)
        val fragobj = ShowFragment()
        fragobj.arguments = bundle

        binding.apply {
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.add(R.id.framelayout, fragobj)
            ft.commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}