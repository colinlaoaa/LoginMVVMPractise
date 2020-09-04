package com.liao.mvvmpractise.view_model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.liao.mvvmpractise.api.Client
import com.liao.mvvmpractise.helper.SessionManager
import com.liao.mvvmpractise.model.User

class RegisterViewModel : ViewModel() {
    val email = ObservableField<String?>()
    val password = ObservableField<String?>()
    val name = ObservableField<String?>()
    private val registerRepository = RegisterRepository(Client.returnEndpoint())
    private var sessionManager = SessionManager()

    fun registerOnClicked() {
        var user = User()
        user.email = email.get().toString()
        user.password = password.get().toString()
        user.name = name.get().toString()
        user.type = "landlord"
        registerRepository.registerUser(user)

    }
    fun saveInfo(user: User){
        sessionManager.saveInfo(user)
    }

    fun registerResponseObserve() = registerRepository.registerResponse
}