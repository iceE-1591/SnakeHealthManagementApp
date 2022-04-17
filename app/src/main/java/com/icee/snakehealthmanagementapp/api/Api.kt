package com.icee.snakehealthmanagementapp.api

import com.icee.snakehealthmanagementapp.constant.Env
import com.icee.snakehealthmanagementapp.repository.UserRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Api {
    private val retrofit : Retrofit
    val userService : UserRepository

    init {
        // Jsonのパースライブラリ
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        // HeaderをBuilderに追加
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor {
            val request = it.request().newBuilder()
                .header(Env.HEADER_NAME, Env.API_KEY)
                .build()
            it.proceed(request)
        }

        // RetrofitをBuild
        val client = httpClient.build()
        this.retrofit = Retrofit.Builder()
            .baseUrl(Env.API_BASEURL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        // Serviceをインスタンスに
        this.userService = this.retrofit.create(UserRepository::class.java)
    }
}
