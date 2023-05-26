package com.example.retrofitapi

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdaper(private val items: ArrayList<UserModelItem> = ArrayList()): RecyclerView.Adapter<UserAdaper.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_single_row, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.nameText.text = currentItem.name
        Glide.with(holder.itemView.context).load(currentItem.photo).into(holder.image)

        holder.nameText.setOnClickListener {
            val intent = Intent(holder.nameText.context, PdfView::class.java)
            intent.putExtra("textName", currentItem.name)
            intent.putExtra("purl", currentItem.pdf)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            holder.nameText.context.startActivity(intent)
        }
        holder.image.setOnClickListener {
            val intent = Intent(holder.image.context, PdfView::class.java)
            intent.putExtra("textName", currentItem.name)
            intent.putExtra("purl", currentItem.pdf)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            holder.image.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var nameText: TextView = itemView.findViewById(R.id.nameView)
        var image: ImageView = itemView.findViewById(R.id.image_single_row)

    }
}