package com.example.jetpackcomposeapp.data.datasources

import android.util.Log.d
import com.example.jetpackcomposeapp.data.ApiService
import com.example.jetpackcomposeapp.data.models.User
import javax.inject.Inject

class DataSourceImpl @Inject constructor(private val apiService: ApiService) : DataSource {
    override suspend fun getAllUsers(): List<User> {
        return apiService.getAllUsers().users
    }

    override suspend fun getUser(id: Int): User {
        d("asdsadsadsadsadsa", apiService.getUser(id).toString())
        return apiService.getUser(id).user
    }

}