package com.android.koinlibrary.model

/**
 * Created by NguyenLinh on 12,November,2020
 */
data class LoadingState private constructor(val status: Status, val msg: String? = null) {
    companion object {
        val LOADED =
            LoadingState(Status.SUCCESS)
        val LOADING =
            LoadingState(Status.RUNNING)
        fun error(msg: String?) = LoadingState(
            Status.FAILED,
            msg
        )
    }

    enum class Status {
        RUNNING,
        SUCCESS,
        FAILED
    }
}