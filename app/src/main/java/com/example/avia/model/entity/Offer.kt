package com.example.avia.model.entity


data class Offer(
    val id: String,
    val price: Int,
    val flights: List<Flight>
) {

    data class Flight(
        val departureLocation: Location,
        val arrivalLocation: Location,
        val departureTimeInfo: TimeInfo,
        val arrivalTimeInfo: TimeInfo,
        val flightNumber: String,
        val airline: Airline,
        val luggage: Int,
        val duration: Int
    ) {

        data class Location(
            val cityName: String,
            val code: String
        )

        data class TimeInfo(
            val timeStr: String
        )

        data class Airline(
            val name: String,
            val code: String
        )
    }
}