package com.example.jetpackcomposeapp.datasources.versionOne

import com.example.jetpackcomposeapp.datasources.DataSource
import javax.inject.Inject

class DataSourceOneImpl @Inject constructor() : DataSource {
    override fun getData() = "Data Source One"
}