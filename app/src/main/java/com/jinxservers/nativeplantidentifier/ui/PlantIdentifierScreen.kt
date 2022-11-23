package com.jinxservers.nativeplantidentifier.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinxservers.nativeplantidentifier.R
import com.jinxservers.nativeplantidentifier.model.Plant
import com.jinxservers.nativeplantidentifier.model.PlantProperty
import com.jinxservers.nativeplantidentifier.model.PlantPropertyCategory

@Preview
@Composable
fun PlantIdentifierScreen(
    modifier: Modifier = Modifier
) {
    var plant by rememberSaveable { mutableStateOf(Plant()) }

    Column() {
        Column(
            modifier = Modifier
                .weight(1f, fill = true)
        ) {
            IdentifierCell(plant = plant, onEditPlant = { plant = it })
        }

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp)
        ) {
            Text(text = stringResource(id = R.string.search))
        }
    }
}