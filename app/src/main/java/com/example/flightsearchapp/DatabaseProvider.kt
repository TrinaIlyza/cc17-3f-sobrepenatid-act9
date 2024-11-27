package com.example.flightsearchapp

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private const val DATABASE_NAME = "flight_search_db"

    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
