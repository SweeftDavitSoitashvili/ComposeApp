package com.example.jetpackcomposeapp.datasources.versionTwo

import com.example.jetpackcomposeapp.datasources.DataSource
import javax.inject.Inject

class DataSourceTwoImpl @Inject constructor() : DataSource{
    override fun getData() = "Data Source Two"
}