package com.taingy.gardeningjournalapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Plant::class],
    version = 1
)
abstract class PlantDatabase : RoomDatabase() {

    abstract fun getPlantDao(): PlantDao

    companion object {
        @Volatile
        private var INSTANCE: PlantDatabase? = null
        private const val DATABASE_NAME = "plant-database"

        fun invoke(context: Context): PlantDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = buildDatabase(context)
                INSTANCE = instance
                instance
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PlantDatabase::class.java,
            DATABASE_NAME
        ).build()

    }
}