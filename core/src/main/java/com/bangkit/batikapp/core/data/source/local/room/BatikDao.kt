package com.bangkit.batikapp.core.data.source.local.room

import androidx.room.*
import com.bangkit.batikapp.core.data.source.local.entity.BatikEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BatikDao {

    @Query("SELECT * FROM batik")
    fun getAllBatik(): Flow<List<BatikEntity>>

    @Query("SELECT * FROM batik WHERE isFavorite = 1")
    fun getFavoriteBatik(): Flow<List<BatikEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBatik(batik: List<BatikEntity>)

    @Update
    fun updateFavoriteBatik(batik: BatikEntity)

}