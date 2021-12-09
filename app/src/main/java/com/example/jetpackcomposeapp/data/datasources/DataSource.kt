package com.example.jetpackcomposeapp.data.datasources

import com.example.jetpackcomposeapp.data.models.User

interface DataSource {
    suspend fun getAllUsers() : List<User>

    suspend fun getUser(id : Int) : User

}