package com.bangkit.batikapp.di

import com.bangkit.batikapp.core.domain.usecase.BatikUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun batikUseCase(): BatikUseCase
}