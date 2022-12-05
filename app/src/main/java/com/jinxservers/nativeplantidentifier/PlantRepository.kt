package com.jinxservers.nativeplantidentifier

import android.content.Context
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteQuery
import com.jinxservers.nativeplantidentifier.database.PlantDatabase
import com.jinxservers.nativeplantidentifier.database.PlantEntity
import kotlinx.coroutines.flow.Flow
import java.lang.IllegalStateException

private const val DATABASE_NAME = "plant-database.db"

class PlantRepository private constructor(
    context: Context
) {
    private val database: PlantDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            PlantDatabase::class.java,
            DATABASE_NAME
        )
        .createFromAsset(DATABASE_NAME)
        .build()

    suspend fun getMatchingPlants(query: SupportSQLiteQuery): List<PlantEntity> = database.plantDao().getMatchingPlants(query)

    companion object {
        private var INSTANCE: PlantRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = PlantRepository(context)
            }
        }

        fun get(): PlantRepository {
            return INSTANCE ?: throw IllegalStateException("PlantRepository must be initialized")
        }
    }
}