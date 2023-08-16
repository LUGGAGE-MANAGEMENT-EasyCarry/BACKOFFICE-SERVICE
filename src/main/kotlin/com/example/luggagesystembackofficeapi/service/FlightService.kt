package com.example.luggagesystembackofficeapi.service

import com.example.luggagesystembackofficeapi.client.flight.FlightAPI
import com.example.luggagesystembackofficeapi.client.flight.dto.response.FlightRequest
import com.example.luggagesystembackofficeapi.client.flight.dto.response.FlightResponse
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class FlightService(private val flightAPI: FlightAPI) {
    suspend fun getFlights(): List<FlightResponse> {
        return flightAPI.getFlights()
    }

    suspend fun createFlight(flightRequest: FlightRequest): FlightResponse {
        return flightAPI.createFlight(flightRequest)
    }
}