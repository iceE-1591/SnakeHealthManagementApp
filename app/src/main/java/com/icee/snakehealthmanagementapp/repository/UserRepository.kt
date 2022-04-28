package com.icee.snakehealthmanagementapp.repository

import retrofit2.http.GET
import retrofit2.http.Path

interface UserRepository {
    @GET("users/search/{address}")
    suspend fun search(@Path("address") address: String) : Boolean
}
