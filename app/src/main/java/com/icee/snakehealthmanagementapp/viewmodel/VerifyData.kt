package com.icee.snakehealthmanagementapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState

class VerifyData(application: Application) : AndroidViewModel(application) {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState : LiveData<ClickedState> = _clickedState
    val code = MutableLiveData("")
    val errorText = MutableLiveData<String>()

    fun toLogin() {
        _clickedState.value = ClickedState.LOGIN
    }

    fun reSend() {
    }
}
