package com.icee.snakehealthmanagementapp.entity

data class User(
    var id: Int = 0,
    var name: String = "",
    var address: String = "",
    var password: String = "",
    var iconPath: String? = null
)
