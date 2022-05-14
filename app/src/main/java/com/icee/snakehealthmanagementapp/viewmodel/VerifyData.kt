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
import com.icee.snakehealthmanagementapp.model.MailModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull

class VerifyData(application: Application) : AndroidViewModel(application) {
    private val _clickedState = LiveEvent<ClickedState>()
    val clickedState : LiveData<ClickedState> = _clickedState
    val code = MutableLiveData("")
    val errorText = MutableLiveData<String>()
    private var job = false

    fun toLogin() {
        _clickedState.value = ClickedState.LOGIN
    }

    fun reSend() {
        if (job) return
        job = true
        viewModelScope.launch {
            val result = withTimeoutOrNull(5000) {
                MailModel().sendCode(SharedDatas.address)
            }
            result ?: Toast.makeText(getApplication(), "インターネットが接続されていない可能性があります。", Toast.LENGTH_LONG).show()
            job = false
        }
    }
}
