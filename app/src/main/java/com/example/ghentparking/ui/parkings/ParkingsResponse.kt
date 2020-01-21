package com.example.ghentparking.ui.parkings

import com.example.ghentparking.data.parkings.DatabaseParking

data class ParkingsResponse(val parkings:List<Parking>)

fun ParkingsResponse.asDatabaseModel():Array<DatabaseParking>{
    return parkings.map{
        DatabaseParking(
            it.id,
            it.name,
            it.description,
            it.latitude,
            it.longitude,
            it.address,
            it.contactInfo,
            it.status
        )
    }.toTypedArray()
}