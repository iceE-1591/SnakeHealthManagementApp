package com.icee.snakehealthmanagementapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState
import com.icee.snakehealthmanagementapp.util.regex

class LoginData(application: Application) : AndroidViewModel(application) {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState: LiveData<ClickedState> = _clickedState
    val checkbox = MutableLiveData<Boolean>()
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val errorText = MutableLiveData<String>()

    fun toMain() {
        _clickedState.value = ClickedState.MAIN
    }
    fun toRegister() {
        _clickedState.value = ClickedState.REGISTER
    }
    fun toVerify() {
        _clickedState.value = ClickedState.VERIFY
    }

    private fun checkEmail() : Boolean {
        val checkedEmail = email.value.toString().regex {
            emailValidation()
        }
        errorText.value = checkedEmail.text
        return checkedEmail.isError
    }
    private fun checkPassword() : Boolean {
        val checkedPassword = password.value.toString().regex {
            passwordValidation()
        }
        errorText.value = checkedPassword.text
        return checkedPassword.isError
    }
}
