package com.example.iyakstore.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.iyakstore.ActivityByCategory
import com.example.iyakstore.Detail
import com.example.iyakstore.MyData
import com.example.iyakstore.model.Category
import com.example.iyakstore.R
import com.example.iyakstore.adapter.ProductAdapter.myProductAdapter
import com.squareup.picasso.Picasso

class CategoryAdapter(var context: Context, var list: ArrayList<Category>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class myCategory(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_cat)
        val image: ImageView = itemView.findViewById(R.id.image_cat)

        fun category(name: String, photos: String){
            title.text = name
            Picasso.get().load(photos).into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_category, parent, false)
        return myCategory(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as myCategory).category(list[position].name, list[position].photo)
        val image: ImageView = holder.itemView.findViewById<ImageView>(R.id.image_cat)
        image.setOnClickListener{
            val intent = Intent(context, ActivityByCategory::class.java)
            MyData.id_Category = list[position].id
            context.startActivity(intent)
        }
    }
}