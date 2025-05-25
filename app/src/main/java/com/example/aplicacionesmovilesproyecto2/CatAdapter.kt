package com.example.aplicacionesmovilesproyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplicacionesmovilesproyecto2.R

class CatAdapter(private val cats: List<Cat>) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat_post, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(cats[position])
    }

    override fun getItemCount() = cats.size

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatar: ImageView = itemView.findViewById(R.id.avatarImage)
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val catImage: ImageView = itemView.findViewById(R.id.catImage)
        private val likes: TextView = itemView.findViewById(R.id.likesText)

        fun bind(cat: Cat) {
            userName.text = cat.userName
            likes.text = "${cat.likes} me gusta"
            Glide.with(itemView).load(cat.avatarUrl).circleCrop().into(avatar)

            val imageResId = itemView.context.resources.getIdentifier(cat.url, "drawable", itemView.context.packageName)
            catImage.setImageResource(imageResId)
        }
    }
}
