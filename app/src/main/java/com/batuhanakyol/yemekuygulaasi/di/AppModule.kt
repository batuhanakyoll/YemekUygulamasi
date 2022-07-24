package com.batuhanakyol.yemekuygulaasi.di

import com.batuhanakyol.yemekuygulaasi.data.repo.YemeklerDaoRepository
import com.batuhanakyol.yemekuygulaasi.retrofit.ApiUtils
import com.batuhanakyol.yemekuygulaasi.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerDaoRepository(kdao:YemeklerDao) : YemeklerDaoRepository{
        return YemeklerDaoRepository(kdao)
    }

    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDao{
        return ApiUtils.getYemeklerDaou()
    }
}