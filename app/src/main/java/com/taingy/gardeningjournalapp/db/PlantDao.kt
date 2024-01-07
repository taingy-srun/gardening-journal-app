package com.taingy.gardeningjournalapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlantDao {

    @Query("SELECT * FROM plant")
    suspend fun getAll(): List<Plant>

    @Query("SELECT * FROM plant WHERE id IN (:id)")
    suspend fun findById(id: Int): Plant

    @Insert
    suspend fun insert(plant: Plant)

    @Update
    suspend fun update(plant: Plant)

    @Delete
    suspend fun delete(plant: Plant)

}