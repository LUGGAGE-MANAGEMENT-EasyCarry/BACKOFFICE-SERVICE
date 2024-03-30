package com.example.luggagesystembackofficeapi.client.flight.dto.response

import java.time.LocalDate
import java.util.Date
import java.util.UUID

data class FlightRequest(
    var pnrCode:String,
    var flightDate: String,
    var departureLocation:String,
    var phoneNumber:Int
)