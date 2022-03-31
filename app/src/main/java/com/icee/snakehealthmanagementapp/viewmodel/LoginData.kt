package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState

class LoginData : ViewModel() {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState : LiveData<ClickedState> = _clickedState
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    fun toMain() {
        _clickedState.value = ClickedState.MAIN
    }
    fun toRegister() {
        _clickedState.value = ClickedState.REGISTER
    }
    fun toVerify() {
        _clickedState.value = ClickedState.VERIFY
    }
}
