package com.example.retrofitwithkotlincoroutineinandroid.show.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.retrofitwithkotlincoroutineinandroid.R
import com.example.retrofitwithkotlincoroutineinandroid.main.activity.MainActivity.Companion.grpList
import com.example.retrofitwithkotlincoroutineinandroid.databinding.FragmentShowBinding

class ShowFragment : Fragment() {
    lateinit var binding:FragmentShowBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentShowBinding.inflate(inflater,container,false)

        val position = arguments?.getInt("POSITION")
        Log.e("TAG", "onCreateView: "+position )

        binding.apply {
            var grpposition     = grpList[position!!]

            Glide.with(this@ShowFragment).load(grpposition.Image)
                .placeholder(R.drawable.ic_launcher_background).into(imageviewshow)

            textviewpromovalue.text = grpposition.PromoCode
            textviewStartDateValue.text = grpposition.ValidityStart
            textviewEndDateValue.text = grpposition.ValidityEnd
            txtCategory.text = grpposition.CategName
            txtDescriptionValue.text = grpposition.Description
        }

        return  binding.root
    }
}