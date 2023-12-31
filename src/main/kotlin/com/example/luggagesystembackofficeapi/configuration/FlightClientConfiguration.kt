package com.example.luggagesystembackofficeapi.configuration

import com.example.luggagesystembackofficeapi.client.flight.FlightAPI
import com.example.luggagesystembackofficeapi.configuration.properties.FlightAPIProperties
import com.example.luggagesystembackofficeapi.util.configureTimeouts
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class FlightClientConfiguration {

    @Bean("flightClient")
    fun flightClient(flightAPIProperties: FlightAPIProperties) = with(flightAPIProperties) {
        WebClient.builder().baseUrl(baseUrl).configureTimeouts(readTimeout, connectTimeout).build()
    }

    @Bean("flightApi")
    fun flightApi(flightClient: WebClient ) = FlightAPI(flightClient)

}