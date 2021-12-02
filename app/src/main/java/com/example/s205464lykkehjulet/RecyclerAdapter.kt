package com.example.s205464lykkehjulet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("Mad og Drikke", "Steder", "Filmtitler")
    private var details = arrayOf("Ordet kan være mad eller en drikkevare", "Ordet kan være et kontinen, land, stat, eller en by")
    private var images = intArrayOf(R.drawable.madbillede, R.drawable.stedbillede, R.drawable.titelbillede)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_category, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
     var itemImage: ImageView
     var itemTitle: TextView
     var itemDetail: TextView

     init {
         itemImage = itemView.findViewById(R.id.itemImage)
         itemTitle = itemView.findViewById(R.id.itemTitle)
         itemDetail = itemView.findViewById(R.id.itemDetail)
     }
    }
}