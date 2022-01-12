package com.naufal.core.di

import com.naufal.core.data.AnimeRepositoryImpl
import com.naufal.core.data.source.local.AnimeDatabase
import com.naufal.core.data.source.remote.MyAnimeListApi
import com.naufal.core.domain.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesAnimeRepository(myAnimeListApi: MyAnimeListApi, animeDatabase: AnimeDatabase): AnimeRepository {
        return AnimeRepositoryImpl(myAnimeListApi, animeDatabase.animeDao)
    }
}