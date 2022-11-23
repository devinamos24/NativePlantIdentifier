package com.jinxservers.nativeplantidentifier.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jinxservers.nativeplantidentifier.model.Plant
import com.jinxservers.nativeplantidentifier.model.PlantProperty

@Composable
fun IdentifierCell(
    @StringRes headerText: Int,
    modifier: Modifier = Modifier,
    buttonModifier: Modifier = Modifier,
    plant: Plant,
    plantProperties: Array<PlantProperty>,
    onEditPlant: (Plant) -> Unit
) {
    Column(
        modifier = Modifier,
    ) {
        Text(
            text = stringResource(id = headerText),
            modifier = Modifier
                .padding(horizontal = 2.dp, vertical = 4.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(20.dp))
                .background(Color.Green),
            textAlign = TextAlign.Center
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            userScrollEnabled = false
        ) {
            items(plantProperties) { property ->
                IdentifierButton(
                    property = property,
                    plant = plant,
                    onClickButton = {
                        onEditPlant(plant.negateProperty(property))
                    })

            }
        }
    }
}

