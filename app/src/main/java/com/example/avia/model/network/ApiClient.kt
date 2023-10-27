package com.example.avia.model.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    private val okHttpClientClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("YOUR_BASE_URL")
        .client(okHttpClientClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
}