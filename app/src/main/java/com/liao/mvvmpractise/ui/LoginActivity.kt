package com.liao.mvvmpractise.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.liao.mvvmpractise.R
import com.liao.mvvmpractise.databinding.ActivityLoginBinding
import com.liao.mvvmpractise.view_model.LoginViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var viewModel: LoginViewModel
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.viewModel = viewModel

        observeData()
    }

    private fun observeData() {
        viewModel.observerLoginResponse().observe(this, Observer {
            if (it != null) {
                if (it.token.isNullOrEmpty()) {
                    Toast.makeText(applicationContext, "fail", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
                    viewModel.saveInfo(it.user!!)
                }
            }else{
                Toast.makeText(applicationContext, "fail", Toast.LENGTH_SHORT).show()
            }
        })
    }
}