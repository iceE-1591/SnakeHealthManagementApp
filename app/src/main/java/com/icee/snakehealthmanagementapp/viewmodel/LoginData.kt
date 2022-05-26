package com.icee.snakehealthmanagementapp.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hadilq.liveevent.LiveEvent
import com.icee.snakehealthmanagementapp.SharedDatas
import com.icee.snakehealthmanagementapp.constant.ClickedState
import com.icee.snakehealthmanagementapp.entity.User
import com.icee.snakehealthmanagementapp.model.MailModel
import com.icee.snakehealthmanagementapp.model.UserModel
import com.icee.snakehealthmanagementapp.util.regex
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull

class LoginData(application: Application) : AndroidViewModel(application) {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState: LiveData<ClickedState> = _clickedState
    val checkbox = MutableLiveData<Boolean>()
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val errorText = MutableLiveData<String>()

    fun toMain() {
        if (checkEmail()) return
        if (checkPassword()) return
        _clickedState.value = ClickedState.MAIN
    }
    fun toRegister() {
        if (checkEmail()) return
        if (checkPassword()) return
        _clickedState.value = ClickedState.REGISTER
    }
    fun toVerify() {
        if (checkEmail()) return
        _clickedState.value = ClickedState.VERIFY
    }

    private fun error(txt: String) {
        errorText.value = txt
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

    private fun search() : Boolean {
        var sResult = false // アカウントが登録されていればtrue
        viewModelScope.launch {
            val result = withTimeoutOrNull(5000) {
                sResult = UserModel().search(email.value.toString())
            }
            result ?: Toast.makeText(getApplication(), "インターネットが接続されていない可能性があります。", Toast.LENGTH_LONG).show()
        }
        return sResult
    }
    private fun login() : User {
        var sResult = User()
        viewModelScope.launch {
            val result = withTimeoutOrNull(5000) {
                sResult = UserModel().login(email.value.toString(), password.value.toString())
            }
            result ?: Toast.makeText(getApplication(), "インターネットが接続されていない可能性があります。", Toast.LENGTH_LONG).show()
        }
        return sResult
    }
    private fun sendCode() {
        viewModelScope.launch {
            val result = withTimeoutOrNull(5000) {
                SharedDatas.address = email.value.toString()
                MailModel().sendCode(email.value.toString())
            }
            result ?: Toast.makeText(getApplication(), "インターネットが接続されていない可能性があります。", Toast.LENGTH_LONG).show()
        }
    }
}
