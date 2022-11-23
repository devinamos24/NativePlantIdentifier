package com.jinxservers.nativeplantidentifier.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinxservers.nativeplantidentifier.model.Plant
import com.jinxservers.nativeplantidentifier.model.PlantProperty
import com.jinxservers.nativeplantidentifier.model.PlantPropertyCategory

@Composable
fun IdentifierCell(
    modifier: Modifier = Modifier,
    buttonModifier: Modifier = Modifier,
    plant: Plant,
    onEditPlant: (Plant) -> Unit
) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(2)) {
        PlantPropertyCategory.values().forEach { propertyCategory ->
            if (propertyCategory.dependencies.any { it in plant.properties} || propertyCategory.dependencies.isEmpty()) {
                item(key = propertyCategory, span = { GridItemSpan(2) }) {
                    IdentifierHeader(propertyCategory = propertyCategory, plant = plant)
                }
                propertyCategory.properties.forEach { property ->
                    item(key = property) {
                        IdentifierButton(
                            modifier = buttonModifier,
                            property = property,
                            plant = plant,
                            onClickButton = { onEditPlant(plant.negateProperty(property)) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun IdentifierHeader(
    propertyCategory: PlantPropertyCategory,
    modifier: Modifier = Modifier,
    plant: Plant,
) {
    Text(
        text = stringResource(id = propertyCategory.text),
        modifier = modifier
            .padding(horizontal = 2.dp, vertical = 4.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))
            .background(Color.Green),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun IdentifierButton(
    property: PlantProperty,
    modifier: Modifier = Modifier,
    plant: Plant,
    onClickButton: () -> Unit
) {
    Button(
        onClick = { onClickButton() },
        modifier = modifier.padding(horizontal = 2.dp, vertical = 4.dp)
    ) {
        var text = stringResource(id = property.text)
        if (plant.properties.contains(property)) {
            text += " is on Plant!"
        }
        Text(text = text)
    }
}

@Preview
@Composable
private fun IdentifierHeaderPreview() {
    val plant = Plant(setOf(PlantProperty.Simple))

    Column() {
        IdentifierHeader(propertyCategory = PlantPropertyCategory.LEAF_TYPE, plant = plant)
    }
}

@Preview
@Composable
private fun IdentifierButtonPreview() {

    val plant = Plant(setOf(PlantProperty.Simple))

    Column() {
        IdentifierButton(property = PlantProperty.Simple, plant = plant) {

        }
        IdentifierButton(property = PlantProperty.Compound, plant = plant) {

        }
    }
}



