package com.example.luggagesystembackofficeapi.client.luggage.dto.response
import java.util.UUID

data class LuggageResponse(val luggageId:UUID?=null, val weight:Float, val flightId: UUID, val customerId: UUID,val state: String)
