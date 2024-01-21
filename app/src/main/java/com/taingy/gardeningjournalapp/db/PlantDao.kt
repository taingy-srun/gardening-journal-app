package com.taingy.gardeningjournalapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlantDao {

    @Query("SELECT * FROM plant")
    fun getAll(): LiveData<List<Plant>>

    @Query("SELECT * FROM plant WHERE id IN (:id)")
    fun findById(id: Int): LiveData<Plant>

    @Insert
    fun insert(plant: Plant)

    @Update
    fun update(plant: Plant)

    @Delete
    fun delete(plant: Plant)

}