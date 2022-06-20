package com.icee.snakehealthmanagementapp.util

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.ImageView

@JvmName("ImageConverter")

fun Uri.toBinary(context: Context): ByteArray? {
    return context.contentResolver.openInputStream(this)?.readBytes()
}

fun ImageView.setImageBinary(binary : ByteArray) {
    val bitmap = BitmapFactory.decodeByteArray(binary, 0, binary.size)
    this.setImageBitmap(bitmap)
}
