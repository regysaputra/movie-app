package com.bangkit.batikapp.core.domain.usecase

import com.bangkit.batikapp.core.domain.model.Batik
import kotlinx.coroutines.flow.Flow

interface BatikUseCase {

    fun getAllBatik(): Flow<com.bangkit.batikapp.core.data.Resource<List<Batik>>>
    fun getFavoriteBatik(): Flow<List<Batik>>
    fun setFavoriteBatik(batik: Batik, state: Boolean)

}