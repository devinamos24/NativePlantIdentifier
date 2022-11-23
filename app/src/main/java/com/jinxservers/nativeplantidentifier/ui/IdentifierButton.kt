package com.jinxservers.nativeplantidentifier.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinxservers.nativeplantidentifier.model.Plant
import com.jinxservers.nativeplantidentifier.model.PlantProperty

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

@Composable
fun IdentifierButton(
    property: PlantProperty,
    modifier: Modifier = Modifier,
    plant: Plant,
    onClickButton: () -> Unit
) {
    Button(
        onClick = { onClickButton() },
        modifier = Modifier.padding(horizontal = 2.dp, vertical = 4.dp)
    ) {

        Text(text = stringResource(id = property.text))
        if (plant.properties.contains(property)) {
            Text(text = " is on Plant!")
        }
    }
}