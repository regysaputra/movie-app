package com.bangkit.batikapp.core.di

import com.bangkit.batikapp.core.domain.repository.IBatikRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(batikRepository: com.bangkit.batikapp.core.data.BatikRepository): IBatikRepository

}