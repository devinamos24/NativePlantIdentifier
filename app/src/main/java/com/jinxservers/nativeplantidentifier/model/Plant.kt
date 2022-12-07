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
                        properties -
                                Simple -
                                PlantPropertyCategory.LEAF_SUBTYPE_SIMPLE.properties.toSet() -
                                PlantPropertyCategory.LEAF_SIMPLE_LOBED.properties.toSet()
                    } else {
                        properties +
                                Simple -
                                Compound -
                                PlantPropertyCategory.LEAF_SUBTYPE_COMPOUND.properties.toSet()
                    }
                }
                // Compound cannot exist with Simple
                Compound -> {
                    if (properties.contains(Compound)) {
                        properties - Compound - PlantPropertyCategory.LEAF_SUBTYPE_COMPOUND.properties.toSet()
                    } else {
                        properties + Compound - Simple - PlantPropertyCategory.LEAF_SUBTYPE_SIMPLE.properties.toSet()
                    }
                }
                SimpleUnlobed -> {
                    if (properties.contains(SimpleUnlobed)) {
                        properties - SimpleUnlobed
                    } else {
                        properties +
                                SimpleUnlobed -
                                SimpleLobed -
                                PlantPropertyCategory.LEAF_SIMPLE_LOBED.properties.toSet()
                    }
                }
                SimpleLobed -> {
                    if (properties.contains(SimpleLobed)) {
                        properties -
                                SimpleLobed -
                                PlantPropertyCategory.LEAF_SIMPLE_LOBED.properties.toSet()
                    } else {
                        properties +
                                SimpleLobed -
                                SimpleUnlobed
                    }
                }
                LobedPinnate -> {
                    if (properties.contains(LobedPinnate)) {
                        properties - LobedPinnate
                    } else {
                        properties +
                                LobedPinnate -
                                LobedPalmate
                    }
                }
                LobedPalmate -> {
                    if (properties.contains(LobedPalmate)) {
                        properties - LobedPalmate
                    } else {
                        properties +
                                LobedPalmate -
                                LobedPinnate
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

