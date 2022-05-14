package com.icee.snakehealthmanagementapp.repository

import retrofit2.http.GET
import retrofit2.http.Path

interface MailRepository {
    @GET("/mail/code/{address}/{code}")
    suspend fun sendCode(@Path("address") address: String, @Path("code") code: String)
}
