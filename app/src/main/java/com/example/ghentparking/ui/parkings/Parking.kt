package com.example.ghentparking.ui.parkings

import com.example.ghentparking.data.parkings.DatabaseParking

data class Parking(
    val id: Int,
    val name: String?,
    val description: String?,
    val latitude: Double?,
    val longitude: Double?,
    val address: String?,
    val contactInfo: String?,
    val parkingStatus: ParkingStatus?
)

fun Parking.asDatabaseModel(): DatabaseParking {
    return DatabaseParking(
        this.id,
        this.name,
        this.description,
        this.latitude,
        this.longitude,
        this.address,
        this.contactInfo,
        this.parkingStatus
    )
}

fun convertParkingToDatabaseParking(parkings: List<Parking>): Array<DatabaseParking> {
    return parkings.map { p -> p.asDatabaseModel() }.toTypedArray()
}