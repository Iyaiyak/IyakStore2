package com.example.iyakstore.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.iyakstore.Detail
import com.example.iyakstore.MyData
import com.example.iyakstore.model.Product
import com.example.iyakstore.R
import com.squareup.picasso.Picasso

class ProductAdapter(var context: Context, var list: ArrayList<Product>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class myProductAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)
        val image: ImageView = itemView.findViewById(R.id.image)


        fun adapter(titles : String, prices: Int, photos: String){
            title.text = titles
            price.text = "Rp. ${prices.toString()} "
            Picasso.get().load(photos).into(image)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_product, parent, false)
        return myProductAdapter(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val image: ImageView = holder.itemView.findViewById<ImageView>(R.id.image)
        (holder as myProductAdapter).adapter(list[position].name, list[position].price,list[position].photo)
        image.setOnClickListener{
        //    Toast.makeText(context,"you have clicked me" + position, Toast.LENGTH_LONG).show()
            val intent = Intent(context, Detail::class.java)
            MyData.id_product = list[position].id
            MyData.names = list[position].name
            MyData.prices = list[position].price
            MyData.photos = list[position].photo
            MyData.descriptions = list[position].description
//            intent.putExtra("id", list[position].id)
//            intent.putExtra("name", list[position].name)
//            intent.putExtra("price", list[position].price)
//            intent.putExtra("photo", list[position].photo)
//            intent.putExtra("description", list[position].description)
            context.startActivity(intent)
        }
    }
}