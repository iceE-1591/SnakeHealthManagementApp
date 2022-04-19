package com.icee.snakehealthmanagementapp

import android.app.Application
import com.icee.snakehealthmanagementapp.api.Api

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Api
    }
}
