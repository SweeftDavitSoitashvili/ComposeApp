package com.example.jetpackcomposeapp.vm

import android.util.Log.d
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposeapp.datasources.DataSource
import com.example.jetpackcomposeapp.di.DataSourceOne
import com.example.jetpackcomposeapp.di.DataSourceTwo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @DataSourceOne private val dataSourceOneImpl: DataSource,
    @DataSourceTwo private val dataSourceTwoImpl: DataSource
) : ViewModel() {
    fun printVersionOne() {
        d("asdsadsadsa", dataSourceOneImpl.getData())
    }

    fun printVersionTwo() {
        d("asdsadsadsa", dataSourceTwoImpl.getData())
    }
}