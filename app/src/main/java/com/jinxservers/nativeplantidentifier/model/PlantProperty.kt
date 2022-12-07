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
    LEAF_SUBTYPE_SIMPLE(R.string.leaf_subtype, listOf(SimpleUnlobed, SimpleLobed), listOf(Simple)),
    LEAF_SIMPLE_LOBED(R.string.leaf_lobed_type, listOf(LobedPinnate, LobedPalmate), listOf(SimpleLobed)),
    LEAF_SUBTYPE_COMPOUND(R.string.leaf_subtype, listOf(CompoundDigitate, CompoundPinnate, CompoundPinnatelyTrifoliate, CompoundPalmatelyTrifoliate, CompoundBipinnate), listOf(Compound)),
    LEAF_PETIOLE(R.string.leaf_petiole_type, listOf(PetiolePetiolate, PetioleSessile, PetioleSubpetiolate, PetioleClasping, PetioleExstipulate, PetioleStipulate), emptyList())
}

enum class PlantProperty(
    @StringRes val text: Int,
    val dataBaseEntry: String,
) {
    Simple(R.string.leaf_simple, "leaf_type_simple"),

    SimpleUnlobed(R.string.leaf_subtype_simple_unlobed, "leaf_subtype_simple_unlobed"),
    SimpleLobed(R.string.leaf_subtype_simple_lobed, "leaf_subtype_simple_lobed"),

    LobedPinnate(R.string.leaf_lobed_pinnate, "leaf_lobed_pinnate"),
    LobedPalmate(R.string.leaf_lobed_palmate, "leaf_lobed_pinnate"),

    Compound(R.string.leaf_compound, "leaf_type_compound"),

    CompoundDigitate(R.string.leaf_subtype_compound_digitate, "leaf_subtype_compound_digitate"),
    CompoundPinnate(R.string.leaf_subtype_compound_pinnate, "leaf_subtype_compound_pinnate"),
    CompoundPinnatelyTrifoliate(R.string.leaf_subtype_compound_pinnately_trifoliate, "leaf_subtype_compound_pinnately_trifoliate"),
    CompoundPalmatelyTrifoliate(R.string.leaf_subtype_compound_palmately_trifoliate, "leaf_subtype_compound_palmately_trifoliate"),
    CompoundBipinnate(R.string.leaf_subtype_compound_bipinnate, "leaf_subtype_compound_bipinnate"),

    PetiolePetiolate(R.string.leaf_petiole_petiolate, "leaf_petiole_petiolate"),
    PetioleSessile(R.string.leaf_petiole_sessile, "leaf_petiole_sessile"),
    PetioleSubpetiolate(R.string.leaf_petiole_subpetiolate, "leaf_petiole_subpetiolate"),
    PetioleClasping(R.string.leaf_petiole_clasping, "leaf_petiole_clasping"),
    PetioleExstipulate(R.string.leaf_petiole_exstipulate, "leaf_petiole_exstipulate"),
    PetioleStipulate(R.string.leaf_petiole_stipulate, "leaf_petiole_stipulate"),




}

