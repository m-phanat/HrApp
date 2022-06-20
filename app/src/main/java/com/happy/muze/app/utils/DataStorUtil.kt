package com.happy.muze.app.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private const val USER_DATASTORE = "datastore"


class DataStoreUtil @Inject constructor(@ApplicationContext private val context: Context) :
    DataStoreInterface {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)

    override suspend fun getPreference(): Preferences =
        context.dataStore.data.first()

    override suspend fun <T> putPreference(key: Preferences.Key<T>, value: T) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    override suspend fun <T> removePreference(key: Preferences.Key<T>) {
        context.dataStore.edit {
            it.remove(key)
        }
    }

    override suspend fun clearAllPreference() {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}

interface DataStoreInterface {
    suspend fun <T> putPreference(key: Preferences.Key<T>, value: T)
    suspend fun <T> removePreference(key: Preferences.Key<T>)
    suspend fun getPreference(): Preferences
    suspend fun clearAllPreference()
}
