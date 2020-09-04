package com.liao.mvvmpractise.view_model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.liao.mvvmpractise.api.Client
import com.liao.mvvmpractise.helper.SessionManager
import com.liao.mvvmpractise.model.User

class LoginViewModel : ViewModel() {
    val email = ObservableField<String?>()
    val password = ObservableField<String?>()
    private val loginRepository = LoginRepository(Client.returnEndpoint())
    var sessionManager = SessionManager()

    fun loginOnClicked(){
        var user = User()
        user.email = email.get().toString()
        user.password = password.get().toString()
        loginRepository.loginUser(user)
    }

    fun saveInfo(user: User){
        sessionManager.saveInfo(user)
    }

    fun onClickCheckedBox(){
        email.set(sessionManager.getEmail())
    }

    fun observerLoginResponse() = loginRepository.loginResponse
}