package com.jinxservers.nativeplantidentifier.database

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "plant")
data class PlantEntity(
    @PrimaryKey val scientificName: String,
    val leaf_type_simple: Boolean,

    val leaf_subtype_simple_unlobed: Boolean,
    val leaf_subtype_simple_lobed: Boolean,

    val leaf_lobed_pinnate: Boolean,
    val leaf_lobed_palmate: Boolean,

    val leaf_type_compound: Boolean,

    val leaf_subtype_compound_digitate: Boolean,
    val leaf_subtype_compound_pinnate: Boolean,
    val leaf_subtype_compound_pinnately_trifoliate: Boolean,
    val leaf_subtype_compound_palmately_trifoliate: Boolean,
    val leaf_subtype_compound_bipinnate: Boolean,

    val leaf_petiole_petiolate: Boolean,
    val leaf_petiole_sessile: Boolean,
    val leaf_petiole_subpetiolate: Boolean,
    val leaf_petiole_clasping: Boolean,
    val leaf_petiole_exstipulate: Boolean,
    val leaf_petiole_stipulate: Boolean,
    )