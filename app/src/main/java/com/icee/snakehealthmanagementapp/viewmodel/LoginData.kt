package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

class LoginData : ViewModel() {
    private val _clickedState = LiveEvent<String>()
    val clickedState : LiveData<String> = _clickedState
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    fun toMain() {
        _clickedState.value = "MAIN"
    }
    fun toRegister() {
        _clickedState.value = "REGISTER"
    }
    fun toVerify() {
        _clickedState.value = "VERIFY"
    }
}
