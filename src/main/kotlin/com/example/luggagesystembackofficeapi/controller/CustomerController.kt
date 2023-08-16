package com.example.luggagesystembackofficeapi.controller

import com.example.luggagesystembackofficeapi.client.customer.CustomerAPI
import com.example.luggagesystembackofficeapi.client.customer.CustomerResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/backoffice/customers")
class CustomerController(private val customerAPI: CustomerAPI) {

    @GetMapping
    suspend fun getAllCustomers(): List<CustomerResponse> {
        return customerAPI.getAllCustomers()
    }

    @GetMapping("/{id}")
    suspend fun getCustomerById(@PathVariable id: UUID): CustomerResponse {
        return customerAPI.getCustomerById(id)
    }
}