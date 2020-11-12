package com.android.koinlibrary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.koinlibrary.base.BaseViewModel
import com.android.koinlibrary.model.LoadingState
import com.android.koinlibrary.model.RepoEntity
import com.android.koinlibrary.repository.RepoRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by NguyenLinh on 12,November,2020
 */
class RepoViewModel(private val repo: RepoRepository) : BaseViewModel() {


    private val _data = MutableLiveData<List<RepoEntity>>()
    val data: LiveData<List<RepoEntity>>
        get() = _data

    fun fetchData(userId: Int) {
        loadingState.postValue(LoadingState.LOADING)
        repo.getListRepoOfUser(userId).enqueue(object : Callback<List<RepoEntity>> {
            override fun onFailure(call: Call<List<RepoEntity>>, t: Throwable) {
                loadingState.postValue(LoadingState.error(t.message))
            }

            override fun onResponse(
                    call: Call<List<RepoEntity>>,
                    response: Response<List<RepoEntity>>
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