package com.jinxservers.nativeplantidentifier.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.jinxservers.nativeplantidentifier.model.PlantProperty.*

@Parcelize
data class Plant(
    val properties: Set<PlantProperty> = emptySet()
) : Parcelable {

    fun negateProperty(property: PlantProperty): Plant {
        return copy(
            properties = when (property) {
                // Simple cannot exist with Compound
                Simple -> {
                    if (properties.contains(Simple)) {
//                        properties - Simple.also {
//                            properties - PlantPropertyCategory.LEAF_SUBTYPE_SIMPLE.properties.toSet()
//                        }
                        properties - Simple - PlantPropertyCategory.LEAF_SUBTYPE_SIMPLE.properties.toSet()
                    } else {
                        properties + Simple - Compound
                    }
                }
                // Compound cannot exist with Simple
                Compound -> {
                    if (properties.contains(Compound)) {
//                        properties - Compound.also {
//                            properties - PlantPropertyCategory.LEAF_SUBTYPE_COMPOUND.properties.toSet()
//                        }
                        properties - Compound - PlantPropertyCategory.LEAF_SUBTYPE_COMPOUND.properties.toSet()
                    } else {
                        properties + Compound - Simple
                    }
                }
                Unlobed -> {
                    if (properties.contains(Unlobed)) {
                        properties - Unlobed
                    } else {
                        properties + Unlobed - Lobed
                    }
                }
                Lobed -> {
                    if (properties.contains(Lobed)) {
                        properties - Lobed
                    } else {
                        properties + Lobed - Unlobed
                    }
                }
                else -> {
                    if (properties.contains(property)) {
                        properties - property
                    } else {
                        properties + property
                    }
                }
            }
        )
    }
}

