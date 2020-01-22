package com.example.ghentparking.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.ghentparking.data.ParkingsDatabase
import com.example.ghentparking.data.parkings.DatabaseParking
import com.example.ghentparking.data.parkings.asDomainModel
import com.example.ghentparking.network.ParkingsAPI
import com.example.ghentparking.ui.parkings.Parking
import com.example.ghentparking.ui.parkings.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ParkingsRepository(
    private val database: ParkingsDatabase
) {

    val parkings: LiveData<List<Parking>> = Transformations.map(
        database.parkingsDao.getParkings()
    ) { it.asDomainModel() }

    suspend fun refreshParkings() {
        withContext(Dispatchers.IO) {
            val parkings = ParkingsAPI.retrofitService.getParkings().await()
            database.parkingsDao.insertAll(*convertParkingToDatabaseParking(parkings))
        }
    }

    private fun convertParkingToDatabaseParking(parkings: List<Parking>): Array<DatabaseParking> {
        return parkings.map { p -> p.asDatabaseModel() }.toTypedArray()
    }
}