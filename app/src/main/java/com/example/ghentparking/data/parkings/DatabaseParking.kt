package com.example.ghentparking.data.parkings

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ghentparking.ui.parkings.Parking
import com.example.ghentparking.ui.parkings.ParkingStatus

@Entity(tableName = "parking")
data class DatabaseParking(
    @PrimaryKey
    val id:Int,
    val name:String?,
    val description:String?,
    val latitude:Double?,
    val longitude:Double?,
    val address:String?,
    val contactInfo:String?,
    @Embedded
    val status: ParkingStatus?
)

fun List<DatabaseParking>.asDomainModel():List<Parking>{
    return map{
        Parking(
            it.id,
            it.name,
            it.description,
            it.latitude,
            it.longitude,
            it.address,
            it.contactInfo,
            it.status
        )
    }
}