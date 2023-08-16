package com.example.luggagesystembackofficeapi.client.flight

import com.example.luggagesystembackofficeapi.client.flight.dto.response.FlightRequest
import com.example.luggagesystembackofficeapi.client.flight.dto.response.FlightResponse
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class FlightAPI( private val flightClient: WebClient) {

    suspend fun createFlight(flightRequest: FlightRequest): FlightResponse {
        return flightClient.post().uri {
            it.path("/api/flights/create").build()
        }.bodyValue(
            flightRequest
        ).retrieve().awaitBody()
    }

    suspend fun getFlights() : List<FlightResponse> {
        return flightClient.get().uri { it.path("/api/flights").build() }.retrieve().awaitBody()
    }


}