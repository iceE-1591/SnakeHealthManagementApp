package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState

class ResetData : ViewModel() {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState : LiveData<ClickedState> = _clickedState
    val password = MutableLiveData<String>()
    val confirm = MutableLiveData<String>()
    val errorText = MutableLiveData<String>()

    fun toMain() {
        _clickedState.value = ClickedState.MAIN
    }
    fun toLogin() {
        _clickedState.value = ClickedState.LOGIN
    }
}
