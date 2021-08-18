package com.bangkit.batikapp.core.di

import android.content.Context
import androidx.room.Room
import com.bangkit.batikapp.core.data.source.local.room.BatikDao
import com.bangkit.batikapp.core.data.source.local.room.BatikDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): BatikDatabase = Room.databaseBuilder(
        context,
        BatikDatabase::class.java, "Batik.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: BatikDatabase): BatikDao = database.batikDao()

}