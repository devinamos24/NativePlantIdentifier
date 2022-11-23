package com.jinxservers.nativeplantidentifier.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.jinxservers.nativeplantidentifier.model.PlantProperty.*

@Parcelize
data class Plant(
    val properties: Set<PlantProperty> = emptySet()
) : Parcelable {

    fun negateProperty(property: PlantProperty): Plant {
        return copy(properties =
            when (property) {
                // Simple cannot exist with Compound
                Simple -> {
                    if (properties.contains(Simple)) {
                        properties - Simple
                    } else {
                        properties + Simple
                        properties - Compound
                    }
                }
                // Compound cannot exist with Simple
                Compound -> {
                    if (properties.contains(Compound)) {
                        properties - Compound
                    } else {
                        properties + Compound
                        properties - Simple
                    }
                }
            }
        )
    }
}

