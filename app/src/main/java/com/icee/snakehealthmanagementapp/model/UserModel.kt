package com.icee.snakehealthmanagementapp.model

import com.icee.snakehealthmanagementapp.Api
import com.icee.snakehealthmanagementapp.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// API実行をして、取得したデータの整形を行うクラス(Fragmentから呼び出される)
class UserModel {
    suspend fun search(address: String) : Boolean =
        withContext(Dispatchers.Default) {
            Api.userService.search(address)
        }
    suspend fun create(user: User) : Int =
        withContext(Dispatchers.Default) {
            Api.userService.create(user)
        }
    suspend fun login(address: String, password: String) : User =
        withContext(Dispatchers.Default) {
            Api.userService.login(address, password)
        }
}
