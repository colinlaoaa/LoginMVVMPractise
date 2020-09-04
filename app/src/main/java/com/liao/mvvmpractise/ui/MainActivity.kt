package com.liao.mvvmpractise.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.liao.mvvmpractise.R
import com.liao.mvvmpractise.helper.SessionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        var sessionManager = SessionManager()
        if (!sessionManager.checkLogin()){
            Toast.makeText(applicationContext,"u Already login",Toast.LENGTH_SHORT).show()
        }
        button_register.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        button_login.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}