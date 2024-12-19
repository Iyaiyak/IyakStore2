package com.example.iyakstore.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.iyakstore.R
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Request.Method
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.iyakstore.adapter.ProductAdapter
import com.example.iyakstore.model.Product

class FragmentHome: Fragment() {

    var list = ArrayList<Product>()
    private lateinit var recycler : RecyclerView
    val new = "192.168.52.179"
    val url: String = "http://$new/store/api_product.php"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val queue: RequestQueue = Volley.newRequestQueue(activity)
        val request = JsonArrayRequest(Request.Method.GET, url, null, { response ->
            for(s in 0 until response.length()){
                val jsonOb = response.getJSONObject(s)
                val id = jsonOb.getInt("id")
                val name = jsonOb.getString("name")
                val photo = jsonOb.getString("photo").replace("localhost", new)
                val price = jsonOb.getInt("price")
                val desc = jsonOb.getString("description")

                list.add(Product(id,name,price,desc,photo))
                val myAdapter = ProductAdapter(requireContext(), list)
                recycler = view.findViewById(R.id.recycleView_fragmentHome)
                recycler.layoutManager = LinearLayoutManager(requireContext())
                recycler.adapter = myAdapter

            }
        }, { error ->
            Log.d("ErrorApp", error.toString())
        })
        queue.add(request)

        return view

    }



    private fun getProduct(adapter: ProductAdapter){

    }

}