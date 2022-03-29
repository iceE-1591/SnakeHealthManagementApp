package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

class RegisterData: ViewModel() {
    private val _clickedState = LiveEvent<String>()
    val clickedState : LiveData<String> = _clickedState

    fun toMain() {
        _clickedState.value = "MAIN"
    }
    fun toLogin() {
        _clickedState.value = "LOGIN"
    }
}
