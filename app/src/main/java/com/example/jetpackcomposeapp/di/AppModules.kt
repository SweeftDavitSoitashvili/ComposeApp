package com.example.jetpackcomposeapp.di

import com.example.jetpackcomposeapp.data.datasources.DataSource
import com.example.jetpackcomposeapp.data.datasources.DataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModules {
    @Binds
    abstract fun bindDataSource(dataSourceImpl: DataSourceImpl) : DataSource
}