package com.icee.snakehealthmanagementapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState
import com.icee.snakehealthmanagementapp.util.regex

class ResetData(application: Application) : AndroidViewModel(application) {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState : LiveData<ClickedState> = _clickedState
    val password = MutableLiveData("")
    val confirm = MutableLiveData<String>()
    val errorText = MutableLiveData<String>()

    fun toMain() {
        _clickedState.value = ClickedState.MAIN
    }
    fun toLogin() {
        _clickedState.value = ClickedState.LOGIN
    }

    fun checkPassword() : Boolean {
        val checkedPassword = password.value.toString().regex {
            passwordValidation()
        }
        errorText.value = checkedPassword.text
        return checkedPassword.isError
    }
    fun checkConfirmPassword() : Boolean {
        val checkedConfirmPassword = confirm.value.toString().regex {
            passwordEquals(password.value.toString())
        }
        errorText.value = checkedConfirmPassword.text
        return checkedConfirmPassword.isError
    }
}
