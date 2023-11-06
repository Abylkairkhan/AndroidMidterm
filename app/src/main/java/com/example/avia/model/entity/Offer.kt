package com.example.avia.model.entity

import com.google.gson.annotations.SerializedName


data class OfferList(
    @SerializedName("offer_list")
    val offerList: MutableList<Offer>
)

data class Offer(
    @SerializedName("id")
    val id: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("flights")
    val flights: List<Flight>
) {

    data class Flight(
        @SerializedName("departure_location")
        val departureLocation: Location,
        @SerializedName("arrival_location")
        val arrivalLocation: Location,
        @SerializedName("departure_time_info")
        val departureTimeInfo: TimeInfo,
        @SerializedName("arrival_time_info")
        val arrivalTimeInfo: TimeInfo,
        @SerializedName("flight_number")
        val flightNumber: String,
        @SerializedName("airline")
        val airline: Airline,
        @SerializedName("luggage")
        val luggage: Int,
        @SerializedName("duration")
        val duration: Int
    ) {

        data class Location(
            @SerializedName("city_name")
            val cityName: String,
            @SerializedName("code")
            val code: String
        )

        data class TimeInfo(
            @SerializedName("time_str")
            val timeStr: String
        )

        data class Airline(
            @SerializedName("name")
            val name: String,
            @SerializedName("code")
            val code: String
        )
    }
}