package com.example.retrofitwithkotlincoroutineinandroid.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitwithkotlincoroutineinandroid.R
import com.example.retrofitwithkotlincoroutineinandroid.databinding.CardviewlayoutBinding
import com.example.retrofitwithkotlincoroutineinandroid.main.model.MainModel

class MainAdapter(
    var context: Context,
    var sencondarraylist: List<MainModel.ResultX>,
    val callbacks: (Int) -> Unit,
) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(val binding: CardviewlayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myview =
            CardviewlayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(myview)
    }

    override fun getItemCount(): Int {
        return sencondarraylist.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(context).load(sencondarraylist[position].Image)
                .placeholder(R.drawable.ic_launcher_background).into(imageview)
            textview.text = sencondarraylist[position].Title
            textviewTwo.text = sencondarraylist[position].Description
        }
        holder.itemView.setOnClickListener {
            callbacks.invoke(position)
        }

        /*holder.binding.image1212.setText(sencondarraylist[position].Result[position].Description)
*/
//        callbacks.invoke(position)

        /*   holder.itemView.setOnClickListener {
               Toast.makeText(context, "dsdg", Toast.LENGTH_SHORT).show()
        }*/
    }
}
