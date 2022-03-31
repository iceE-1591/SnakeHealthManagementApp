package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState

class RegisterData: ViewModel() {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState : LiveData<ClickedState> = _clickedState
    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    fun toMain() {
        _clickedState.value = ClickedState.MAIN
    }
    fun toLogin() {
        _clickedState.value = ClickedState.LOGIN
    }
}
