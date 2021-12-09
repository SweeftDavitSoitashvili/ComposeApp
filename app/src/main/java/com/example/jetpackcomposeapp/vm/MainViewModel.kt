package com.example.jetpackcomposeapp.vm

import androidx.lifecycle.ViewModel
import com.example.jetpackcomposeapp.data.datasources.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataSource: DataSource
) : ViewModel() {

    suspend fun getAllUsers() = dataSource.getAllUsers()

    suspend fun getUser(id : Int) = dataSource.getUser(id)

}