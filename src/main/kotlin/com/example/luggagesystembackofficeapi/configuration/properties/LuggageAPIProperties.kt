package com.example.luggagesystembackofficeapi.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import java.time.Duration


@ConfigurationProperties("luggage-system-luggage-api")
data class LuggageAPIProperties(
    val baseUrl: String,
    val connectTimeout: Duration,
    val readTimeout: Duration
)