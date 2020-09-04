package com.liao.mvvmpractise.view_model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.liao.mvvmpractise.api.EndPoint
import com.liao.mvvmpractise.model.User
import com.liao.mvvmpractise.model.UserInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository(private var endPoint: EndPoint) {
    val loginResponse: MutableLiveData<UserInfo> by lazy {
        MutableLiveData<UserInfo>()
    }

    fun loginUser(user: User){
        endPoint.loginUser(user).enqueue(object : Callback<UserInfo>{
            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                var response = response.body()
                loginResponse.postValue(response)
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Log.d("MyTag","fail")
            }
        })

    }

}