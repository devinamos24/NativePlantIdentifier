package com.jinxservers.nativeplantidentifier.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.jinxservers.nativeplantidentifier.R
import com.jinxservers.nativeplantidentifier.model.Plant

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
//                .verticalScroll(rememberScrollState())
        ) {
            LeafTypeIdentifierCell(
                headerText = R.string.leaf_type,
                plant = plant,
                onEditPlant = { plant = it })
            }

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.search))
        }
    }
}