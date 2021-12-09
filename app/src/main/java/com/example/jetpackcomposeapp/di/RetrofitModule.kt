package com.example.jetpackcomposeapp.di

import com.example.jetpackcomposeapp.data.ApiService
import com.example.jetpackcomposeapp.data.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {
    @Provides
    fun provideApiService() : ApiService = RetrofitClient.retrofit.create(ApiService::class.java)
}