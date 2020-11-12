package com.android.koinlibrary.repository

import com.android.koinlibrary.api.ApiInterface

/**
 * Created by NguyenLinh on 12,November,2020
 */
class RepoRepository(private val apiInterface: ApiInterface) {
    fun getListRepoOfUser(userId :Int) = apiInterface.getRepository(userId)
}