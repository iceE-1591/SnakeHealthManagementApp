package com.icee.snakehealthmanagementapp.view

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.icee.snakehealthmanagementapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(!resources.getBoolean(R.bool.is_tablet)) // 表示機器がスマートフォンの場合は縦画面固定にする
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        navMain()
    }

    fun navMain() {
        setContentView(R.layout.activity_main)
    }

    fun navLogin() {
        setContentView(R.layout.activity_login)
    }
}
