package com.icee.snakehealthmanagementapp.entity

data class User(
    var id: Int,
    var name: String,
    var address: String,
    var password: String,
    var iconPath: String?
)
