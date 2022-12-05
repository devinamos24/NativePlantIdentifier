package com.jinxservers.nativeplantidentifier.database

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "plant")
data class PlantEntity(
    @PrimaryKey val scientificName: String,
    val leaf_simple: Boolean,
    val leaf_unlobed: Boolean,
    val leaf_lobed: Boolean,
    val leaf_compound: Boolean,
    val leaf_digitate: Boolean,
    val leaf_pinnate: Boolean,
    val leaf_pinnately_trifoliate: Boolean,
    val leaf_palmately_trifoliate: Boolean,
    val leaf_bipinnate: Boolean,
    )