package com.example.iyakstore

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.w3c.dom.Text
import java.util.logging.Logger

class Login: AppCompatActivity() {

    private lateinit var login : Button
    private lateinit var name : TextView
    private lateinit var password : TextView
    private lateinit var register : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        register = findViewById(R.id.button_register_loginPage)
        name = findViewById(R.id.name_tv_loginPage)
        password = findViewById(R.id.password_tv_loginPage)
        login = findViewById(R.id.button_login_loginPage)

        val ip = BuildConfig.IP_ADDRESS
        val url= "http://$ip/store/login.php"

        login.setOnClickListener{
            val request:RequestQueue = Volley.newRequestQueue(applicationContext)

            val stringRequest = StringRequest(Request.Method.GET,url+"?email="+name.text.toString().trim()+"&password="+password.text.toString().trim(),
                { response ->
                        if (response.trim() == "1") {
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                                Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    },
                { error ->
                    Log.d("errorApp", error.toString())
                Toast.makeText(applicationContext, "Network Error: ${error.message}", Toast.LENGTH_SHORT).show()
                    Logger.getLogger("Login").warning("Network Error: ${error.message}")
                })
            request.add(stringRequest)
            }

        register.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }


        }





}



