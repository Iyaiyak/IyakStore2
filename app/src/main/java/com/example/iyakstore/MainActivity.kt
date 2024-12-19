package com.example.iyakstore


import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.iyakstore.fragment.FragmentAccount
import com.example.iyakstore.fragment.FragmentHome
import com.example.iyakstore.fragment.FragmentProduct
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val bottomNavi = findViewById<BottomNavigationView>(R.id.bottomNavi_Main)
        callFragment(FragmentHome())
        bottomNavi.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.home->{
                    //Toast.makeText(applicationContext,"Home", Toast.LENGTH_SHORT).show()
                    callFragment(FragmentHome())
                    return@setOnItemSelectedListener true
                }
                R.id.product->{
                //    Toast.makeText(applicationContext,"Product", Toast.LENGTH_SHORT).show()
                    callFragment(FragmentProduct())
                    return@setOnItemSelectedListener true
                }
                R.id.account->{
                //    Toast.makeText(applicationContext,"Account", Toast.LENGTH_SHORT).show()
                    callFragment(FragmentAccount())
                    return@setOnItemSelectedListener true
                }

            }
            false
        }



    }

    private fun callFragment(frag : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment, frag).commit()
    }




}