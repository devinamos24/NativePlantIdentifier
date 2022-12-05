package com.jinxservers.nativeplantidentifier.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {

//    @Query("SELECT * FROM plants")
//    suspend fun getPlants(): Flow<List<PlantEntity>>

    @RawQuery
    suspend fun getMatchingPlants(query: SupportSQLiteQuery): List<PlantEntity>

//    @Query("SELECT COUNT(*) FROM plants")
//    suspend fun getTotalPlants(): Int
}