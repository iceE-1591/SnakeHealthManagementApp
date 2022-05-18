package com.icee.snakehealthmanagementapp.model

import com.icee.snakehealthmanagementapp.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// API実行をして、取得したデータの整形を行うクラス(Fragmentから呼び出される)
class UserModel {
    suspend fun search(address: String) : Boolean =
        withContext(Dispatchers.Default) {
            Api.userService.search(address)
        }
}
