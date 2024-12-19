package com.example.iyakstore

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.iyakstore.adapter.ProductAdapter
import com.example.iyakstore.model.Product

class ActivityByCategory : AppCompatActivity() {

    private lateinit var recycler : RecyclerView
    var list = ArrayList<Product>()
    val new = "192.168.52.179"
    val url: String = "http://$new/store/api_productId.php?cat_id="+ MyData.id_Category

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        val queue: RequestQueue = Volley.newRequestQueue(applicationContext)
        val request = JsonArrayRequest(Request.Method.GET, url, null, { response ->
            for(s in 0 until response.length()){
                val jsonOb = response.getJSONObject(s)
                val id = jsonOb.getInt("id")
                val name = jsonOb.getString("name")
                val photo = jsonOb.getString("photo").replace("localhost", new)
                val price = jsonOb.getInt("price")
                val desc = jsonOb.getString("description")

                list.add(Product(id,name,price,desc,photo))
                val myAdapter = ProductAdapter(applicationContext, list)
                recycler = findViewById(R.id.recycleView_fragmentHome)
                recycler.layoutManager = LinearLayoutManager(applicationContext)
                recycler.adapter = myAdapter

            }
        }, { error ->
            Log.d("ErrorApp", error.toString())
        })
        queue.add(request)
    }
}