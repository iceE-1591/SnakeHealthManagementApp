package com.icee.snakehealthmanagementapp.repository

import com.icee.snakehealthmanagementapp.entity.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRepository {
    @GET("users/{address}")
    suspend fun search(@Path("address") address: String) : Boolean

    @GET("users/login/{address}/{password}")
    suspend fun login(@Path("address") address: String, @Path("password") password: String) : User
}
