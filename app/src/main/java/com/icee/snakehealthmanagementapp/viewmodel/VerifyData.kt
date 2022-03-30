package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

class VerifyData : ViewModel() {
    private val _clickedState = LiveEvent<String>()
    val clickedState : LiveData<String> = _clickedState
    private val _code = MutableLiveData<String>()
    val code : LiveData<String> = _code

    fun toReset() {
        _clickedState.value = "RESET"
    }
    fun toLogin() {
        _clickedState.value = "LOGIN"
    }
}
