package com.android.koinlibrary
import android.app.Application
import com.android.koinlibrary.module.apiModule
import com.android.koinlibrary.module.repositoryModule
import com.android.koinlibrary.module.retrofitModule
import com.android.koinlibrary.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
/**
 * Created by NguyenLinh on 12,November,2020
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }
}