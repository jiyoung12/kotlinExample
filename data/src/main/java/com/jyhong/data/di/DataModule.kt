package com.jyhong.data.di

import com.jyhong.data.repositoryimpl.NewsRepositoryImpl
import com.jyhong.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository = newsRepositoryImpl
}