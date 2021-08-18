package com.bangkit.batikapp.core.domain.repository

import com.bangkit.batikapp.core.data.Resource
import com.bangkit.batikapp.core.domain.model.Batik
import kotlinx.coroutines.flow.Flow

interface IBatikRepository {

    fun getAllBatik(): Flow<Resource<List<Batik>>>

    fun getFavoriteBatik(): Flow<List<Batik>>

    fun setFavoriteBatik(batik: Batik, state: Boolean)

}