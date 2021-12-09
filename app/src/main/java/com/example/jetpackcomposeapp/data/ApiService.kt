package com.example.jetpackcomposeapp.data

import com.example.jetpackcomposeapp.data.models.AllUser
import com.example.jetpackcomposeapp.data.models.SingleUser
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users")
    suspend fun getAllUsers() : AllUser

    @GET("user/{id}")
    suspend fun getUser(@Path("id") id : Int) : SingleUser
}