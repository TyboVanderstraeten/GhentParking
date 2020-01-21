package com.example.ghentparking.ui.parkings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ghentparking.App
import com.example.ghentparking.data.ParkingsDatabase
import com.example.ghentparking.data.repository.ParkingsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class ParkingsAPIStatus { LOADING, ERROR, DONE }
class ParkingsViewModel : ViewModel() {

    private val database = ParkingsDatabase.getInstance(App.context)
    private val parkingsRepository = ParkingsRepository(database)
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val parkings = parkingsRepository.parkings

    private val _status = MutableLiveData<ParkingsAPIStatus>()
    val status: LiveData<ParkingsAPIStatus>
        get() = _status

    fun getParkings() {
        coroutineScope.launch {
            try {
                _status.value = ParkingsAPIStatus.LOADING
                parkingsRepository.refreshParkings()
                _status.value = ParkingsAPIStatus.DONE
            } catch (e: Exception) {
                _status.value = ParkingsAPIStatus.ERROR
            }
        }
    }

    override fun onCleared(){
        super.onCleared()
        viewModelJob.cancel()
    }
}