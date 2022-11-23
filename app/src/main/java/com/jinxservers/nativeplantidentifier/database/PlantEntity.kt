package com.jinxservers.nativeplantidentifier.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlantEntity(
    @PrimaryKey val scientificName: String,
    val description: String
)