package com.example.flightsearchapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AirportDao {

    @Insert
    suspend fun insertAirport(airport: Airport)

    @Query("SELECT * FROM airport WHERE iata_code LIKE :query OR name LIKE :query ORDER BY passengers DESC")
    suspend fun searchAirports(query: String): List<Airport>
}
