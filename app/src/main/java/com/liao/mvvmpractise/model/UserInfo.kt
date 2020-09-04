package com.liao.mvvmpractise.model

data class UserInfo(
    val token: String?=null,
    val user: User?=null,

    val `data`: Data?=null,
    val error: Boolean?=null,
    val message: String?=null
)

data class User(
    val __v: Int?=null,
    val _id: String?=null,
    val createdAt: String?=null,
    var email: String?=null,
    var name: String?=null,
    var password: String?=null,
    var type: String?=null
)


data class Data(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val landlordEmail: String,
    val name: String,
    val password: String,
    val type: String
)