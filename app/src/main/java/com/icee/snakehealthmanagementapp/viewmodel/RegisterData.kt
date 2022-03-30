package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

class RegisterData: ViewModel() {
    private val _clickedState = LiveEvent<String>()
    val clickedState : LiveData<String> = _clickedState
    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    fun toMain() {
        _clickedState.value = "MAIN"
    }
    fun toLogin() {
        _clickedState.value = "LOGIN"
    }
}
