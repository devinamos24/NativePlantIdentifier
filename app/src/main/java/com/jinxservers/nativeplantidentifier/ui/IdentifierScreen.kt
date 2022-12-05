package com.jinxservers.nativeplantidentifier.ui

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jinxservers.nativeplantidentifier.IdentifierViewModel
import com.jinxservers.nativeplantidentifier.R

@Preview
@Composable
fun IdentifierScreen(
    modifier: Modifier = Modifier,
    identifierViewModel: IdentifierViewModel = viewModel()
) {
    val plant by identifierViewModel.plant.collectAsState()
    val plants by identifierViewModel.plants.collectAsState()
    Column() {
        Column(
            modifier = Modifier
                .weight(1f, fill = true)
        ) {
            IdentifierCell(plant = plant, onEditPlant = { identifierViewModel.onPlantChange(it) })
        }

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp)
        ) {
            val plantAmount by animateIntAsState(targetValue = plants.size)
            val text = stringResource(id = R.string.search) + " $plantAmount"
            Text(text = text)
        }
    }
}