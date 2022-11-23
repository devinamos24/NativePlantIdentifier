package com.jinxservers.nativeplantidentifier.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {

    @Query("SELECT * FROM plantentity")
    fun getPlants(): Flow<List<PlantEntity>>

    @Query("SELECT COUNT(*) FROM plantentity")
    fun getTotalPlants(): Int
}