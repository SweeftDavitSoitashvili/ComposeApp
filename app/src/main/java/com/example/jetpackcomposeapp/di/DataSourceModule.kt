package com.example.jetpackcomposeapp.di

import android.app.Activity
import com.example.jetpackcomposeapp.datasources.DataSource
import com.example.jetpackcomposeapp.datasources.versionOne.DataSourceOneImpl
import com.example.jetpackcomposeapp.datasources.versionTwo.DataSourceTwoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    @DataSourceOne
    abstract fun provideDataSourceOne(dataSourceOneImpl: DataSourceOneImpl) : DataSource

    @Binds
    @DataSourceTwo
    abstract fun provideDataSourceTwo(dataSourceTwoImpl: DataSourceTwoImpl) : DataSource

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DataSourceOne

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DataSourceTwo
