package com.example.ghentparking.ui.parkings

data class Parking(
    val id:Int,
    val name:String?,
    val description:String?,
    val latitude:Int?,
    val longitude:Int?,
    val address:String?,
    val contactInfo:String?,
    val status:ParkingStatus?
)