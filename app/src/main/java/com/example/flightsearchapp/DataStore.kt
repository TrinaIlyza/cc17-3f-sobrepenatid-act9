package com.example.flightsearchapp

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

val Context.dataStore by preferencesDataStore(name = "settings")

val QUERY_KEY = stringPreferencesKey("last_query")

suspend fun saveQuery(context: Context, query: String) {
    context.dataStore.edit { preferences ->
        preferences[QUERY_KEY] = query
    }
}

suspend fun getQuery(context: Context): String? {
    val preferences = context.dataStore.data.first()
    return preferences[QUERY_KEY]
}
