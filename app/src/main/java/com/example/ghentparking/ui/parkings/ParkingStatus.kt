package com.example.ghentparking.ui.parkings

data class ParkingStatus(
    val availableCapacity:Int,
    val totalCapacity:Int,
    val open:Boolean,
    val lastModifiedDate:String
)