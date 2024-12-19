package com.example.iyakstore

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class Detail: AppCompatActivity() {
    private lateinit var title: TextView
    private lateinit var price: TextView
    private lateinit var photo: ImageView
    private lateinit var desc: TextView
    private lateinit var order: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        order = findViewById(R.id.orderButton_detail)
        title = findViewById(R.id.title_detail)
        price = findViewById(R.id.price_detail)
        photo = findViewById(R.id.image_detail)
        desc = findViewById(R.id.description_detail)
        var id_product = MyData.id_product
//        var names = intent.getStringExtra("name")
//        var prices = intent.getIntExtra("price",0)
//        var photos = intent.getStringExtra("photo")
//        var descriptions = intent.getStringExtra("description")



        title.text = MyData.names
        Picasso.get().load(MyData.photos).into(photo)
        price.text = "Rp. ${MyData.prices.toString()}"
        desc.text = MyData.descriptions

        order.setOnClickListener{
            var i = Intent(applicationContext, Order::class.java)
//            intent.putExtra("id", id_product)
//            intent.putExtra("name", names)
//            intent.putExtra("price", prices)
//            intent.putExtra("photo", photos)
//            intent.putExtra("description", descriptions)
            startActivity(i)
        }

        Log.d("myID", id_product.toString())


    }
}