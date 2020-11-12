package com.android.koinlibrary.module

import com.android.koinlibrary.repository.UserRepository
import com.android.koinlibrary.viewmodel.UserViewModel
import com.android.koinlibrary.api.ApiInterface
import com.android.koinlibrary.repository.RepoRepository
import com.android.koinlibrary.viewmodel.RepoViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by NguyenLinh on 12,November,2020
 */
val viewModelModule = module {
    viewModel {
        UserViewModel(get())
    }
    viewModel {
        RepoViewModel(get())
    }
}

val repositoryModule = module {
    single {
        UserRepository(get())
    }
    single {
        RepoRepository(get())
    }
}

val apiModule = module {
    fun provideApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    single { provideApi(get()) }
}

val retrofitModule = module {

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}