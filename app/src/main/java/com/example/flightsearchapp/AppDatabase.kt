package com.example.flightsearchapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Airport::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun airportDao(): AirportDao
}
