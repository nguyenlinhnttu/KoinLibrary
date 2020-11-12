package com.android.koinlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.android.koinlibrary.viewmodel.RepoViewModel
import com.android.koinlibrary.viewmodel.UserViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val userViewModel : UserViewModel by viewModel()
    private val repoViewModel : RepoViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userViewModel.fetchData()
        userViewModel.data.observe(this, Observer {
            Log.d( "userViewModel","userViewModel.data$it")
        })

        userViewModel.loadingState.observe(this, Observer {
            Log.d( "userViewModel","loadingState$it")
        })

        repoViewModel.fetchData(31)
        repoViewModel.data.observe(this, Observer {
            Log.d( "userViewModel","repoViewModel.data$it")
        })

    }
}