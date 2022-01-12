package com.naufal.core.di

import android.app.Application
import androidx.room.Room
import com.naufal.core.data.source.local.AnimeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideAnimeDatabase(application: Application): AnimeDatabase {
        return Room.databaseBuilder(
            application,
            AnimeDatabase::class.java,
            AnimeDatabase.DATABASE_NAME
        ).build()
    }
}