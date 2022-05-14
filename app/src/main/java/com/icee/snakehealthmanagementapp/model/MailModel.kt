package com.icee.snakehealthmanagementapp.model

import com.icee.snakehealthmanagementapp.Api
import com.icee.snakehealthmanagementapp.SharedDatas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MailModel {
    suspend fun sendCode(address: String) =
        withContext(Dispatchers.Default) {
            val code = (0..9999).random().toString().padStart(4, '0')
            SharedDatas.code = code
            Api.mailService.sendCode(address, code)
        }
}
