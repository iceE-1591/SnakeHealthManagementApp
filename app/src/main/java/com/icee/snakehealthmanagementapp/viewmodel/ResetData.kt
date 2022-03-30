package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

class ResetData : ViewModel() {
    private val _clickedState = LiveEvent<String>()
    val clickedState : LiveData<String> = _clickedState
    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password
    private val _confirm = MutableLiveData<String>()
    val confirm : LiveData<String> = _confirm

    fun toMain() {
        _clickedState.value = "MAIN"
    }
    fun toLogin() {
        _clickedState.value = "LOGIN"
    }
}
