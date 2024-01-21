package com.taingy.gardeningjournalapp.db

import android.app.Application
import androidx.lifecycle.LiveData

class PlantRepository(application: Application) {

    private val plantDao: PlantDao
    private val allPlants: LiveData<List<Plant>>

    init {
        val database = PlantDatabase.invoke(application)
        plantDao = database.getPlantDao()
        allPlants = plantDao.getAll()
    }

    suspend fun insert(plant: Plant) {
        plantDao.insert(plant)
    }

    suspend fun update(plant: Plant) {
        plantDao.update(plant)
    }

    suspend fun delete(plant: Plant) {
        plantDao.delete(plant)
    }

    fun getPlantById(plantId: Int): LiveData<Plant> {
        return plantDao.findById(plantId)
    }

    fun getAllPlants() : LiveData<List<Plant>> {
        return allPlants
    }
}
