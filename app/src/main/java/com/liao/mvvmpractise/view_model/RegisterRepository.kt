package com.liao.mvvmpractise.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.liao.mvvmpractise.api.EndPoint
import com.liao.mvvmpractise.model.User
import com.liao.mvvmpractise.model.UserInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterRepository(private var endPoint: EndPoint) {

    val registerResponse: MutableLiveData<UserInfo> by lazy {
        MutableLiveData<UserInfo>()
    }

    fun registerUser(user: User){
        endPoint.registerUser(user).enqueue(object :Callback<UserInfo>{
            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                var response = response.body()
                registerResponse.postValue(response)
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Log.d("MyTag","fail")
            }
        })

    }
}