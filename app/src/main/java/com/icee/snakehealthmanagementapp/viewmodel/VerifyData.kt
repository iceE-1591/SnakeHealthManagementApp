package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState

class VerifyData : ViewModel() {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState : LiveData<ClickedState> = _clickedState
    private val _code = MutableLiveData<String>()
    val code : LiveData<String> = _code

    fun toReset() {
        _clickedState.value = ClickedState.RESET
    }
    fun toLogin() {
        _clickedState.value = ClickedState.LOGIN
    }
}
