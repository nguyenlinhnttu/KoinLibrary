package com.android.koinlibrary.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.koinlibrary.model.LoadingState

/**
 * Created by NguyenLinh on 12,November,2020
 */
open class BaseViewModel : ViewModel() {
    val loadingState = MutableLiveData<LoadingState>()
}