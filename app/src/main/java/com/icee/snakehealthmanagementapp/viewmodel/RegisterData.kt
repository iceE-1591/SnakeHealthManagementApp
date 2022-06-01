package com.icee.snakehealthmanagementapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState
import com.icee.snakehealthmanagementapp.util.regex

class RegisterData: ViewModel() {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState : LiveData<ClickedState> = _clickedState
    val name = MutableLiveData<String>()
    val errorText = MutableLiveData<String>()

    fun toIcon() {
        _clickedState.value = ClickedState.ICON
    }
    fun toMain() {
        _clickedState.value = ClickedState.MAIN
    }
    fun toLogin() {
        _clickedState.value = ClickedState.LOGIN
    }

    private fun checkName() : Boolean {
        val checkedName = name.value.toString().regex {
            nameValidation()
        }
        errorText.value = checkedName.text
        return checkedName.isError
    }
}
