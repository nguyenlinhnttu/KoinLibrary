package com.android.koinlibrary.repository

import com.android.koinlibrary.api.ApiInterface

/**
 * Created by NguyenLinh on 12,November,2020
 */
class UserRepository(private val apiInterface: ApiInterface) {
    fun getAllUsers() = apiInterface.getUsers()
}