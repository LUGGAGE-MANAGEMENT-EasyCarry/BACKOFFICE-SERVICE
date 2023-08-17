package com.example.luggagesystembackofficeapi.service

import com.example.luggagesystembackofficeapi.client.luggage.LuggageAPI
import com.example.luggagesystembackofficeapi.client.luggage.LuggageRequest
import com.example.luggagesystembackofficeapi.client.luggage.dto.response.LuggageResponse
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class LuggageService(private val luggageAPI: LuggageAPI) {
    suspend fun getLuggageByCustomerIdAndLuggageIdWithState(customerId: UUID, luggageId: UUID): LuggageResponse {
        return luggageAPI.getLuggageByCustomerIdAndLuggageIdWithState(customerId, luggageId)
    }

    suspend fun getLuggages(): List<LuggageResponse> {
        return luggageAPI.getLuggages()
    }

    suspend fun createLuggage(luggageRequest: LuggageRequest): LuggageResponse {

        return luggageAPI.createLuggage(luggageRequest)
    }

    suspend fun updateLuggage(id: UUID, luggageRequest: LuggageRequest): LuggageResponse {
        return luggageAPI.update(id, luggageRequest)

    }

    suspend fun updateLuggageForState(id: UUID, state: String): LuggageResponse {
        return luggageAPI.updateLuggageForStateInfo(id, state)
    }
}