package com.jinxservers.nativeplantidentifier.model

import androidx.annotation.StringRes
import com.jinxservers.nativeplantidentifier.R


enum class PlantProperty(
    @StringRes val text: Int,
    val dataBaseEntry: String,
) {
    Simple(R.string.leaf_simple, "leaf_simple"),
    Compound(R.string.leaf_compound, "leaf_compound")
}

