package com.example.ghentparking.ui.parkings

data class ParkingStatus(
    val availableCapcaity:Int,
    val totalCapacity:Int,
    val open:Boolean,
    val lastModifiedDate:String
)