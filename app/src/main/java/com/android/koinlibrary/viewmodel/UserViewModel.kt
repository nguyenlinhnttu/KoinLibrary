package com.android.koinlibrary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.koinlibrary.base.BaseViewModel
import com.android.koinlibrary.model.LoadingState
import com.android.koinlibrary.model.UserEntity
import com.android.koinlibrary.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by NguyenLinh on 12,November,2020
 */
class UserViewModel(private val repo: UserRepository) : BaseViewModel() {

    private val _data = MutableLiveData<List<UserEntity>>()
    val data: LiveData<List<UserEntity>>
        get() = _data

    fun fetchData() {
        loadingState.postValue(LoadingState.LOADING)
        repo.getAllUsers().enqueue(object : Callback<List<UserEntity>> {
            override fun onFailure(call: Call<List<UserEntity>>, t: Throwable) {
                loadingState.postValue(LoadingState.error(t.message))
            }

            override fun onResponse(
                    call: Call<List<UserEntity>>,
                    response: Response<List<UserEntity>>
            ) {
                if (response.isSuccessful) {
                    _data.postValue(response.body())
                    loadingState.postValue(LoadingState.LOADED)
                } else {
                    loadingState.postValue(LoadingState.error(response.errorBody().toString()))
                }
            }

        })
    }

}