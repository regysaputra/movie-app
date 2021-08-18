package com.bangkit.batikapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bangkit.batikapp.core.data.source.local.entity.BatikEntity

@Database(entities = [BatikEntity::class], version = 2, exportSchema = false)
abstract class BatikDatabase : RoomDatabase(){

    abstract fun batikDao(): BatikDao

}