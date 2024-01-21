package com.taingy.gardeningjournalapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.taingy.gardeningjournalapp.db.Plant
import com.taingy.gardeningjournalapp.db.PlantRepository
import kotlinx.coroutines.launch

class GardenLogViewModel(application: Application) : AndroidViewModel(application) {

    private val plantRepository: PlantRepository
    private val allPlants: LiveData<List<Plant>>
    init {
        plantRepository = PlantRepository(application)
        allPlants = plantRepository.getAllPlants()
    }

    fun save(plant: Plant) = viewModelScope.launch {
        plantRepository.insert(plant)
    }

    fun update(plant: Plant)  = viewModelScope.launch {
        plantRepository.update(plant)
    }

    fun getAllPlants() : LiveData<List<Plant>> {
        return allPlants
    }

}