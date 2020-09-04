package com.liao.mvvmpractise.api

import com.liao.mvvmpractise.app.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private val endPoint: EndPoint by lazy {
        val client = Retrofit.Builder().baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        client.create(EndPoint::class.java)
    }

    fun returnEndpoint() = endPoint
}