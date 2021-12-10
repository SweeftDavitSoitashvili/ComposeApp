package com.example.jetpackcomposeapp.vm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposeapp.data.datasources.DataSource
import com.example.jetpackcomposeapp.data.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataSource: DataSource
) : ViewModel() {

    val users = mutableStateOf<List<User>>(listOf())

    val user = mutableStateOf(User())

    suspend fun getAllUsers() {
        users.value = dataSource.getAllUsers()
    }

    suspend fun getUser(id : Int) {
        user.value = dataSource.getUser(id)
    }

}