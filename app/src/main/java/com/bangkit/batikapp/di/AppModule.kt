package com.bangkit.batikapp.di

import com.bangkit.batikapp.core.domain.usecase.BatikInteractor
import com.bangkit.batikapp.core.domain.usecase.BatikUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideBatikUseCase(batikInteractor: BatikInteractor): BatikUseCase

}