package com.example.jetpackcomposeapp.data.datasources

import com.example.jetpackcomposeapp.data.ApiService
import com.example.jetpackcomposeapp.data.models.User
import javax.inject.Inject

class DataSourceImpl @Inject constructor(private val apiService: ApiService) : DataSource {
    override suspend fun getAllUsers(): List<User> {
        return apiService.getAllUsers().users
    }

    override suspend fun getUser(id: Int): User {
        return apiService.getUser(id).user
    }

}