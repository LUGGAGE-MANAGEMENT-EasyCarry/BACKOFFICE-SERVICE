package com.example.luggagesystembackofficeapi.client.customer

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import java.util.UUID

@Component
class CustomerAPI(private val customerClient: WebClient) {
    suspend fun getAllCustomers(): List<CustomerResponse> {
        return customerClient.get().uri {
            it.path("/customers").build()
        }.retrieve().awaitBody<List<CustomerResponse>>().toList()
    }

    suspend fun getCustomerById(@PathVariable id: UUID): CustomerResponse {
        return customerClient.get().uri { it.path("/customers/{id}").build(id) }.retrieve().awaitBody()
    }

}