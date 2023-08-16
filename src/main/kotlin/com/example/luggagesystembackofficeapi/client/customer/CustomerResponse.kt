package com.example.luggagesystembackofficeapi.client.customer

import java.time.LocalDate
import java.util.UUID

data class CustomerResponse(val id:UUID , val name: String, val email: String,var phoneNumber: String)