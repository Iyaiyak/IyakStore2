package com.example.iyakstore

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class Order: AppCompatActivity() {
    private lateinit var productName: TextView
    private lateinit var productImage: ImageView
    private lateinit var productPrice: TextView
    private lateinit var productDesc: TextView
    private lateinit var orderButton: Button
    private lateinit var amountEdit : EditText
    private lateinit var noteEdit : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        productName = findViewById(R.id.title_order)
        productImage = findViewById(R.id.image_order)
        productPrice = findViewById(R.id.price_order)
        productDesc = findViewById(R.id.description_order)
        orderButton = findViewById(R.id.continueButton_order)
        amountEdit = findViewById(R.id.amount_order)
        noteEdit = findViewById(R.id.note_order)

        productName.text = MyData.names
        productPrice.text = "Rp. ${MyData.prices.toString()}"
        productDesc.text = MyData.descriptions
        Picasso.get().load(MyData.photos).into(productImage)

        orderButton.setOnClickListener{
            var priceProduct = MyData.prices
            var priceEdit = amountEdit.text.toString()
            var convertPrice = priceEdit.toInt()
            var total =convertPrice * priceProduct.toInt()
            Log.d("Show", "${total.toInt()}")



        }



    }
}