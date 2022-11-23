package com.jinxservers.nativeplantidentifier.model

import androidx.annotation.StringRes
import com.jinxservers.nativeplantidentifier.R
import com.jinxservers.nativeplantidentifier.model.PlantProperty.*

enum class PlantPropertyCategory(
    @StringRes val text: Int,
    val properties: List<PlantProperty>,
    val dependencies: List<PlantProperty>
) {
    LEAF_TYPE(R.string.leaf_type, listOf(Simple, Compound), emptyList()),
    LEAF_SUBTYPE_SIMPLE(R.string.leaf_subtype, listOf(Unlobed, Lobed), listOf(Simple)),
    LEAF_SUBTYPE_COMPOUND(R.string.leaf_subtype, listOf(Digitate, Pinnate, PinnatelyTrifoliate, PalmatelyTrifoliate, Bipinnate), listOf(Compound))
}

enum class PlantProperty(
    @StringRes val text: Int,
    val dataBaseEntry: String,
) {
    Simple(R.string.leaf_simple, "leaf_simple"),
    Unlobed(R.string.leaf_unlobed, "leaf_unlobed"),
    Lobed(R.string.leaf_lobed, "leaf_lobed"),

    Compound(R.string.leaf_compound, "leaf_compound"),
    Digitate(R.string.leaf_digitate, "leaf_digitate"),
    Pinnate(R.string.leaf_pinnate, "leaf_pinnate"),
    PinnatelyTrifoliate(R.string.leaf_pinnately_trifoliate, "leaf_pinnately_trifoliate"),
    PalmatelyTrifoliate(R.string.leaf_palmately_trifoliate, "leaf_palmately_trifoliate"),
    Bipinnate(R.string.leaf_bipinnate, "leaf_bipinnate"),
}

