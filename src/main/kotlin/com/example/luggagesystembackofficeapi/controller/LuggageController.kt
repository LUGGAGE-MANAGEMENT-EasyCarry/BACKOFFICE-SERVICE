package com.example.luggagesystembackofficeapi.controller

import com.example.luggagesystembackofficeapi.client.luggage.LuggageRequest
import com.example.luggagesystembackofficeapi.client.luggage.dto.response.LuggageResponse
import com.example.luggagesystembackofficeapi.client.luggage.enums.State
import com.example.luggagesystembackofficeapi.service.LuggageService
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import org.springframework.web.bind.annotation.CrossOrigin

@RestController
@RequestMapping("backoffice/api/v1/luggage")
@CrossOrigin("http://localhost:3000")
class LuggageController(private val luggageService: LuggageService) {

    @GetMapping("/luggagebyId")
    suspend fun getLuggageByCustomerIdAndLuggageIdWithState(@RequestParam customerId: UUID, @RequestParam luggageId: UUID): LuggageResponse {
        return luggageService.getLuggageByCustomerIdAndLuggageIdWithState(customerId, luggageId)
    }

    @GetMapping
    suspend fun getLuggages(): List<LuggageResponse> {
        return luggageService.getLuggages()
    }

    @PostMapping
    suspend fun createLuggage(@RequestBody luggageRequest: LuggageRequest): LuggageResponse {
        return luggageService.createLuggage(luggageRequest)
    }

    @PatchMapping("/{id}")
    suspend fun update(@PathVariable id: UUID, @RequestBody luggageRequest: LuggageRequest): LuggageResponse {
        return luggageService.updateLuggage(id, luggageRequest)
    }

    @PatchMapping("/edit/status/{id}")
    suspend fun updateLuggageForStateInfo(@PathVariable id: UUID, @RequestParam state: State): LuggageResponse {
        return luggageService.updateLuggageForState(id, state)
    }
}