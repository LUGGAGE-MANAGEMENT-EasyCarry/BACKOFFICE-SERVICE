package com.example.luggagesystembackofficeapi.client.luggage
import java.util.UUID

data class LuggageRequest(val luggageId:UUID?=null,val weight: Float, val flightId: UUID, val customerId: UUID, val state: String)
