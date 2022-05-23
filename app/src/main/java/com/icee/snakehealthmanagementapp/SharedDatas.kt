package com.icee.snakehealthmanagementapp

import com.icee.snakehealthmanagementapp.entity.User

object SharedDatas {
    private var code = ""
    private var id: Int = 0
    private var name: String = ""
    private var address: String = ""
    private var iconPath: String? = null

    fun setUser(user: User) {
        id = user.id
        name = user.name
        address = user.address
        iconPath = user.iconPath
    }
    fun setCode(code: String) {
        this.code = code
    }
}
