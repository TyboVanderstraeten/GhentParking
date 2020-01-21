package com.example.ghentparking

import android.app.Application
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class App : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    companion object {
        var application: Application? = null
            private set

        val context: Context
            get() = application!!.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }


}
