package com.example.luggagesystembackofficeapi.client.luggage

import com.example.luggagesystembackofficeapi.client.luggage.dto.response.LuggageResponse
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.bodyToFlow
import java.util.UUID

@Component
class LuggageAPI(private val luggageClient: WebClient) {

    suspend fun getLuggages(): List<LuggageResponse> {
        return luggageClient.get().uri {
            it.path("/api/v1/luggage").build()
        }.retrieve().awaitBody()
    }

    suspend fun createLuggage(luggageRequest: LuggageRequest): LuggageResponse {
        return luggageClient.post().uri { it.path("api/v1/luggage").build() }.bodyValue(luggageRequest).retrieve().awaitBody()
    }

    suspend fun update(@PathVariable id: UUID, luggageRequest: LuggageRequest): LuggageResponse {
        return luggageClient.patch().uri { it.path("api/v1/luggage/{id}").build(id) }.bodyValue(luggageRequest).retrieve()
            .awaitBody()
    }

    suspend fun getLuggageByCustomerIdAndLuggageIdWithState(@RequestParam customerId: UUID, @RequestParam luggageId: UUID): LuggageResponse {
        return luggageClient.get().uri { it.path("api/v1/luggage/luggagebyId").build(customerId, luggageId) }.retrieve().awaitBody()
    }

    suspend fun updateLuggageForStateInfo(@PathVariable id: UUID, @RequestParam state: String): LuggageResponse {
        return luggageClient.patch().uri { it.path("api/v1/luggage/edit/status/{id}").queryParam("state",state).build(id) }.retrieve().awaitBody()

    }

}