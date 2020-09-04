package com.liao.mvvmpractise.api

import com.liao.mvvmpractise.app.EndPoints
import com.liao.mvvmpractise.model.User
import com.liao.mvvmpractise.model.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EndPoint {
    @POST(EndPoints.LOGIN)
    fun loginUser(@Body user: User): Call<UserInfo>


    @POST(EndPoints.REGISTER)
    fun registerUser(@Body user: User): Call<UserInfo>
}