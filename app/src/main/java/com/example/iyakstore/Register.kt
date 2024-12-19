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

class Register: AppCompatActivity() {
    private lateinit var register: Button
    private lateinit var username: TextView
    private lateinit var email: TextView
    private lateinit var password : TextView
    private lateinit var phone : TextView
    private lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register = findViewById(R.id.button_register_registerPage)
        username = findViewById(R.id.name_tv_registerPage)
        email = findViewById(R.id.email_tv_registerPage)
        password = findViewById(R.id.password_tv_registerPage)
        phone = findViewById(R.id.phone_tv_registerPage)
        login = findViewById(R.id.button_login_registerPage)

        val ip = "192.168.52.179"
        val registerUrl = "http://$ip/store/register.php"

        register.setOnClickListener{
            if(username.text.toString().isEmpty() || email.text.toString().isEmpty() || phone.text.toString().isEmpty() || password.text.toString().isEmpty() ){
                Toast.makeText(applicationContext,"Please Complete all fields", Toast.LENGTH_LONG).show()
            }else{
                var request: RequestQueue = Volley.newRequestQueue(applicationContext)
                var strRequest = StringRequest(Request.Method.GET, registerUrl+"?username="+username.text.toString().trim()+"&email="+email.text.toString().trim()
                +"&phone="+phone.text.toString().trim()+"&password="+password.text.toString().trim(),
                    { response ->

                        if(response.trim() == "1"){
                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)
                            Toast.makeText(applicationContext,"Register Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(applicationContext,"Data Already Used", Toast.LENGTH_SHORT).show()
                        }

                    },
                    { error ->
                        Log.d("ErrorApps", error.toString())
                    })
                request.add(strRequest)
            }
        }

        login.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }

}