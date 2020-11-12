package com.android.koinlibrary.api

import com.android.koinlibrary.model.RepoEntity
import com.android.koinlibrary.model.UserEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by NguyenLinh on 12,November,2020
 */
interface ApiInterface {

    @GET("users")
    fun getUsers(): Call<List<UserEntity>>

    @GET("/users/{userId}/repos")
    fun getRepository(@Path("userId") userId: Int): Call<List<RepoEntity>>
}