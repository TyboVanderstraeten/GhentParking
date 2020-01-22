package com.example.ghentparking.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ghentparking.data.parkings.DatabaseParking
import com.example.ghentparking.data.parkings.ParkingsDao

@Database(
    entities = [DatabaseParking::class],
    version = 4,
    exportSchema = false
)
abstract class ParkingsDatabase : RoomDatabase() {

    abstract val parkingsDao:ParkingsDao

    companion object {
        @Volatile
        private var INSTANCE: ParkingsDatabase? = null

        fun getInstance(context: Context): ParkingsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ParkingsDatabase::class.java,
                        "parkings_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}