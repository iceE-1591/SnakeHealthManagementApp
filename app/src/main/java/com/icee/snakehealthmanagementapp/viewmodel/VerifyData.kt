package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState
import com.icee.snakehealthmanagementapp.util.regex

class VerifyData : ViewModel() {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState : LiveData<ClickedState> = _clickedState
    val code = MutableLiveData("")
    val errorText = MutableLiveData<String>()

    fun toReset() {
        _clickedState.value = ClickedState.RESET
    }
    fun toLogin() {
        _clickedState.value = ClickedState.LOGIN
    }

    fun checkCode() : Boolean {
        val checkedCode = code.value.toString().regex {
            codeValidation()
        }
        errorText.value = checkedCode.text
        return checkedCode.isError
    }
    fun reSend() {
    }
}
