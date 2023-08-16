package com.example.luggagesystembackofficeapi.client.flight.dto.response

import java.time.LocalDate
import java.util.UUID

data class FlightResponse(val flightId: UUID?=null, var pnrCode:String, var flightDate: LocalDate, var departureLocation:String, var phoneNumber:Int)