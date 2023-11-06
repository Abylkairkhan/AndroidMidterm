package com.example.avia.model.network

import com.example.avia.model.entity.OfferList
import retrofit2.http.GET

interface MainApi {

    @GET("estharossa/android-avia-db/db")
    suspend fun getFlights(): OfferList
}