package com.example.ghentparking.data.parkings

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ParkingsDao {

    @Query("SELECT * FROM parking")
    fun getParkings():LiveData<List<DatabaseParking>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg parkings:DatabaseParking)
}