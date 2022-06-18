package com.icee.snakehealthmanagementapp

import com.icee.snakehealthmanagementapp.entity.User

object SharedDatas {
    var code = ""
    var id: Int = 0
    var name: String = ""
    var address: String = ""
    var iconPath: String? = null
    var checkBox: Boolean = false

    fun setUser(user: User) {
        id = user.id
        name = user.name
        address = user.address
        iconPath = user.iconPath
    }
}
