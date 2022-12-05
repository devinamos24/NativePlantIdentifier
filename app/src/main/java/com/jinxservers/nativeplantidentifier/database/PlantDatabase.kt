package com.jinxservers.nativeplantidentifier.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ PlantEntity::class ], version = 1)
abstract class PlantDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantDao
}