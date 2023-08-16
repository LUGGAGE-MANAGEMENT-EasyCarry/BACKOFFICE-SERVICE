package com.example.luggagesystembackofficeapi.controller

import com.example.luggagesystembackofficeapi.client.flight.dto.response.FlightRequest
import com.example.luggagesystembackofficeapi.client.flight.dto.response.FlightResponse
import com.example.luggagesystembackofficeapi.service.FlightService
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("backoffice/api/flights")
@CrossOrigin("http://localhost:3000")
class FlightController(private val flightService: FlightService) {

    @GetMapping
    suspend fun getFlights() : List<FlightResponse> {
        return flightService.getFlights()
    }

    @PostMapping("/create")
    suspend fun createFlight(@RequestBody flightRequest: FlightRequest):FlightResponse{
        return  flightService.createFlight(flightRequest)
    }

}