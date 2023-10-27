package com.example.avia.model.service

import com.example.avia.model.entity.Offer
import java.util.UUID

object FakeService {

    val offerList = listOf(
        Offer(
            id = UUID.randomUUID().toString(),
            price = 24550,
            flights = listOf(
                Offer.Flight(
                    departureLocation = Offer.Flight.Location(
                        cityName = "Алматы",
                        code = "ALA"
                    ),
                    departureTimeInfo = Offer.Flight.TimeInfo(
                        timeStr = "20:30"
                    ),
                    arrivalLocation = Offer.Flight.Location(
                        cityName = "Астана",
                        code = "NQZ"
                    ),
                    arrivalTimeInfo = Offer.Flight.TimeInfo(
                        timeStr = "22-30"
                    ),
                    flightNumber = "981",
                    airline = Offer.Flight.Airline(
                        name = "Air Astana",
                        code = "KC"
                    ),
                    luggage = 20,
                    duration = 120
                )
            )
        ),
        Offer(
            id = UUID.randomUUID().toString(),
            price = 24550,
            flights = listOf(
                Offer.Flight(
                    departureLocation = Offer.Flight.Location(
                        cityName = "Алматы",
                        code = "ALA"
                    ),
                    departureTimeInfo = Offer.Flight.TimeInfo(
                        timeStr = "20:30"
                    ),
                    arrivalLocation = Offer.Flight.Location(
                        cityName = "Астана",
                        code = "NQZ"
                    ),
                    arrivalTimeInfo = Offer.Flight.TimeInfo(
                        timeStr = "22-30"
                    ),
                    flightNumber = "981",
                    airline = Offer.Flight.Airline(
                        name = "Air Astana",
                        code = "KC"
                    ),
                    luggage = 20,
                    duration = 120
                )
            )
        ),
        Offer(
            id = UUID.randomUUID().toString(),
            price = 24550,
            flights = listOf(
                Offer.Flight(
                    departureLocation = Offer.Flight.Location(
                        cityName = "Алматы",
                        code = "ALA"
                    ),
                    departureTimeInfo = Offer.Flight.TimeInfo(
                        timeStr = "20:30"
                    ),
                    arrivalLocation = Offer.Flight.Location(
                        cityName = "Астана",
                        code = "NQZ"
                    ),
                    arrivalTimeInfo = Offer.Flight.TimeInfo(
                        timeStr = "22-30"
                    ),
                    flightNumber = "981",
                    airline = Offer.Flight.Airline(
                        name = "Air Astana",
                        code = "KC"
                    ),
                    luggage = 20,
                    duration = 120
                )
            )
        ),
        Offer(
            id = UUID.randomUUID().toString(),
            price = 24550,
            flights = listOf(
                Offer.Flight(
                    departureLocation = Offer.Flight.Location(
                        cityName = "Алматы",
                        code = "ALA"
                    ),
                    departureTimeInfo = Offer.Flight.TimeInfo(
                        timeStr = "20:30"
                    ),
                    arrivalLocation = Offer.Flight.Location(
                        cityName = "Астана",
                        code = "NQZ"
                    ),
                    arrivalTimeInfo = Offer.Flight.TimeInfo(
                        timeStr = "22-30"
                    ),
                    flightNumber = "981",
                    airline = Offer.Flight.Airline(
                        name = "Air Astana",
                        code = "KC"
                    ),
                    luggage = 20,
                    duration = 120
                )
            )
        ),
        Offer(
            id = UUID.randomUUID().toString(),
            price = 24550,
            flights = listOf(
                Offer.Flight(
                    departureLocation = Offer.Flight.Location(
                        cityName = "Алматы",
                        code = "ALA"
                    ),
                    departureTimeInfo = Offer.Flight.TimeInfo(
                        timeStr = "20:30"
                    ),
                    arrivalLocation = Offer.Flight.Location(
                        cityName = "Астана",
                        code = "NQZ"
                    ),
                    arrivalTimeInfo = Offer.Flight.TimeInfo(
                        timeStr = "22-30"
                    ),
                    flightNumber = "981",
                    airline = Offer.Flight.Airline(
                        name = "Air Astana",
                        code = "KC"
                    ),
                    luggage = 20,
                    duration = 120
                )
            )
        )
    )
}