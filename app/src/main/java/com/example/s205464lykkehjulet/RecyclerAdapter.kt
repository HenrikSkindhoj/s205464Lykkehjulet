package com.example.s205464lykkehjulet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

/**
 * A recycleradapter used to put information into the category fragment, and the putting a list
 * of all the categories into the showcategory fragment
 */
class RecyclerAdapter(val data: DataViewModel): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("Mad", "Steder", "Filmtitler")
    private var details = arrayOf("Ordet kan være madvarer", "Ordet kan være et land, stat, eller by", "Titlen på en film")
    private var images = intArrayOf(R.drawable.madbillede, R.drawable.stedbillede, R.drawable.titelbillede)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_category, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
        holder.constraint.setOnClickListener{
            data.chooseCategory(holder.itemTitle.text.toString())
            Navigation.findNavController(holder.itemView).navigate(R.id.catToPlay)

        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
     var itemImage: ImageView
     var itemTitle: TextView
     var itemDetail: TextView
     var constraint: ConstraintLayout

     init {
         itemImage = itemView.findViewById(R.id.itemImage)
         itemTitle = itemView.findViewById(R.id.itemTitle)
         itemDetail = itemView.findViewById(R.id.itemDetail)
         constraint = itemView.findViewById(R.id.relativeLayout)
     }
    }
}