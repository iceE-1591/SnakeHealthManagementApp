package com.icee.snakehealthmanagementapp.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.constant.ClickedState
import com.icee.snakehealthmanagementapp.entity.User
import com.icee.snakehealthmanagementapp.model.UserModel
import com.icee.snakehealthmanagementapp.util.regex
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull

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

    private fun error(txt: String) {
        errorText.value = txt
    }

    private fun checkName() : Boolean {
        val checkedName = name.value.toString().regex {
            nameValidation()
        }
        errorText.value = checkedName.text
        return checkedName.isError
    }

    private fun create(user: User) : Int {
        var sResult = 0
        viewModelScope.launch {
            val result = withTimeoutOrNull(5000) {
                sResult = UserModel().create(user)
            }
            result ?: Toast.makeText(getApplication(), "インターネットが接続されていない可能性があります。", Toast.LENGTH_LONG).show()
        }
        return sResult
    }
}
