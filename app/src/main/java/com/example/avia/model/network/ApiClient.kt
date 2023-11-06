package com.example.avia.model.network

import com.example.avia.model.entity.OfferList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "https://my-json-server.typicode.com/"
object ApiClient {

    private val okHttpClientClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClientClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    private val flightsApi = retrofit.create(MainApi::class.java)

    fun getFlightsApi(): MainApi{
        return flightsApi
    }

}