package com.icee.snakehealthmanagementapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState
import com.icee.snakehealthmanagementapp.util.regex

class RegisterData(application: Application) : AndroidViewModel(application) {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState : LiveData<ClickedState> = _clickedState
    val name = MutableLiveData<String>()
    val errorText = MutableLiveData<String>()

    fun toIcon() {
        _clickedState.value = ClickedState.ICON
    }
    fun toMain() {
        if (checkName()) return
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
