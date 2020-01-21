package com.example.ghentparking.network

import com.example.ghentparking.ui.parkings.ParkingsResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl("https://datatank.stad.gent/4/mobiliteit/bezettingparkingsrealtime.json/")
    .build()

interface ParkingsService {

    @GET()
    fun getParkings():
            Deferred<ParkingsResponse>
}

object ParkingsAPI{
    val retrofitService:ParkingsService by lazy{ retrofit.create(ParkingsService::class.java)}
}