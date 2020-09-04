package com.liao.mvvmpractise.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.liao.mvvmpractise.R
import com.liao.mvvmpractise.databinding.ActivityRegisterBinding
import com.liao.mvvmpractise.model.User
import com.liao.mvvmpractise.view_model.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.viewModel = viewModel

        observeData()

    }

    private fun observeData() {
        viewModel.registerResponseObserve().observe(this, Observer {
            if (it != null) {
                if (it.error == false) {
                    var user = User()
                    user.email = it.data?.email
                    user.password = it.data?.password
                    viewModel.saveInfo(user)
                    var myIntent = Intent(this, LoginActivity::class.java)
                    startActivity(myIntent)
                }

            } else {
                Toast.makeText(applicationContext, "fail", Toast.LENGTH_SHORT).show()

            }
        })
    }
}