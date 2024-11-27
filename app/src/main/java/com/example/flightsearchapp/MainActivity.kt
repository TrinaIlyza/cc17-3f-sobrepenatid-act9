package com.example.flightsearchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var airportDao: AirportDao
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize database and DAO
        database = DatabaseProvider.getDatabase(this)
        airportDao = database.airportDao()

        // Example of inserting an airport
        lifecycleScope.launch(Dispatchers.IO) {
            val airport = Airport(iata_code = "LAX", name = "Los Angeles International", passengers = 87000000)
            airportDao.insertAirport(airport)

            // Example of searching for airports
            val airports = airportDao.searchAirports("LAX")
            println(airports)  // This will print the search results in the log
        }
    }
}

