package com.example.luggagesystembackofficeapi.configuration

import com.example.luggagesystembackofficeapi.configuration.properties.CustomerAPIProperties
import com.example.luggagesystembackofficeapi.util.configureTimeouts
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class CustomerClientConfiguration {
    @Bean("customerClient")
    fun customerClient(customerAPIProperties: CustomerAPIProperties)= with(customerAPIProperties) {
    WebClient.builder().baseUrl(baseUrl).configureTimeouts(readTimeout,connectTimeout).build()
    }
}