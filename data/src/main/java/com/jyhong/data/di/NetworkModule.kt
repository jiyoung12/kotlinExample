package com.jyhong.data.di

import com.jyhong.data.datasource.NewsNetworkDataSource
import com.jyhong.data.network.NewsNetwork
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    @Provides
    @Singleton
    fun okhttpCallFactory(): Call.Factory =
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }).build()


}

@Module
@InstallIn(SingletonComponent::class)
interface RetrofitModule {
    @Singleton
    @Binds
    fun bindsNewsNetworkDataSource(newsNetwork: NewsNetwork): NewsNetworkDataSource
}