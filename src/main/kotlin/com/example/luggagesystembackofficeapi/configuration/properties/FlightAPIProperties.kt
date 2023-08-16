package com.example.luggagesystembackofficeapi.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import java.time.Duration

@ConfigurationProperties("luggage-system-flight-api")
data class FlightAPIProperties (val baseUrl: String,
                                val connectTimeout: Duration,
                                val readTimeout: Duration
)