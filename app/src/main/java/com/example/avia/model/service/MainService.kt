package com.example.avia.model.service

import com.example.avia.model.entity.OfferList
import com.example.avia.model.network.ApiClient

class MainService() {

    suspend fun getData(): OfferList {
        return ApiClient.getFlightsApi().getFlights()
    }
}