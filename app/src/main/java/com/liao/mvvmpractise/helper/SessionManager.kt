package com.liao.mvvmpractise.helper

import android.content.Context
import com.liao.mvvmpractise.app.MyApplication
import com.liao.mvvmpractise.model.User

class SessionManager {
    private val context = MyApplication.instance
    private var sharedPreferences = context.getSharedPreferences("My_file",Context.MODE_PRIVATE)
    private var editor = sharedPreferences.edit()

    private var EMAIL = "email"
    private var PASSWORD = "password"


    fun saveInfo(user: User){
        editor.putString(EMAIL,user.email)
        editor.putString(PASSWORD,user.password)
        editor.commit()
    }

    fun checkLogin():Boolean{
        return sharedPreferences.getString(EMAIL,"").isNullOrEmpty()
    }

    fun getEmail(): String? {
        return sharedPreferences.getString(EMAIL,"")

    }


}