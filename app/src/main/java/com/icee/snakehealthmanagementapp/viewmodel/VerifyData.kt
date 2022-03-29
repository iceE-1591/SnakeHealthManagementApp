package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

class VerifyData : ViewModel() {
    private val _clickedState = LiveEvent<String>()
    val clickedState : LiveData<String> = _clickedState

    fun toReset() {
        _clickedState.value = "RESET"
    }
    fun toLogin() {
        _clickedState.value = "LOGIN"
    }
}
