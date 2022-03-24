package com.icee.snakehealthmanagementapp.entity

import android.widget.ImageView
import android.widget.TextView

data class RowData(
    var imagePath: String,
    var name: String
)

data class ViewHolderItem(
    val icon: ImageView,
    val name: TextView
)