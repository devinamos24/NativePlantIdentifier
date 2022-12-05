package com.jinxservers.nativeplantidentifier

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.jinxservers.nativeplantidentifier.database.PlantEntity
import com.jinxservers.nativeplantidentifier.model.Plant
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class IdentifierViewModel: ViewModel() {
    private val plantRepository = PlantRepository.get()

    private val _plant: MutableStateFlow<Plant> = MutableStateFlow(Plant())
    val plant: StateFlow<Plant> = _plant.asStateFlow()

    private val _plants: MutableStateFlow<List<PlantEntity>> = MutableStateFlow(emptyList())
    val plants: StateFlow<List<PlantEntity>>
        get() = _plants.asStateFlow()

    fun onPlantChange(newPlant: Plant) {
        _plant.value = newPlant
        viewModelScope.launch {
            _plants.value = plantRepository.getMatchingPlants(buildQuery(newPlant))
            Log.d("IdentifierViewModel", "there are ${_plants.value.size} plants matching")
        }
    }

    private fun buildQuery(plant: Plant): SupportSQLiteQuery {
        val queryStart = "SELECT * FROM plant"
        var queryEnd = ""
        if (plant.properties.isNotEmpty()) {
            queryEnd = plant.properties.fold(" WHERE ") { sum, property ->
                if (property != plant.properties.last()) {
                    sum + "${property.dataBaseEntry} = TRUE AND "
                } else {
                    sum + "${property.dataBaseEntry} = TRUE"
                }
            }
        }
        return SimpleSQLiteQuery(queryStart + queryEnd)
    }

    init {
        viewModelScope.launch {
            _plants.value = plantRepository.getMatchingPlants(buildQuery(_plant.value))
        }
    }
}