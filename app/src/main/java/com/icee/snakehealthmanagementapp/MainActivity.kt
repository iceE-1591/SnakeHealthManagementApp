package com.icee.snakehealthmanagementapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navMain()
    }

    fun navMain() {
        setContentView(R.layout.activity_main)
    }

    fun navLogin() {
        setContentView(R.layout.activity_login)
    }
}