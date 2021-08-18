package com.bangkit.batikapp.core.data.source.local

import com.bangkit.batikapp.core.data.source.local.entity.BatikEntity
import com.bangkit.batikapp.core.data.source.local.room.BatikDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val batikDao: BatikDao) {

    fun getAllBatik(): Flow<List<BatikEntity>> = batikDao.getAllBatik()

    fun getFavoriteBatik(): Flow<List<BatikEntity>> = batikDao.getFavoriteBatik()

    suspend fun insertBatik(batikList: List<BatikEntity>) = batikDao.insertBatik(batikList)

    fun setFavoriteBatik(batik: BatikEntity, newState: Boolean) {
        batik.isFavorite = newState
        batikDao.updateFavoriteBatik(batik)
    }

}