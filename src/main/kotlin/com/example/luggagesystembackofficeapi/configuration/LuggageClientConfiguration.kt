package com.example.luggagesystembackofficeapi.configuration

import com.example.luggagesystembackofficeapi.client.luggage.LuggageAPI
import com.example.luggagesystembackofficeapi.configuration.properties.LuggageAPIProperties
import com.example.luggagesystembackofficeapi.util.configureTimeouts
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class LuggageClientConfiguration {


    @Bean("luggageClient")
    fun luggageClient(luggageAPIProperties: LuggageAPIProperties) = with(luggageAPIProperties) {
        WebClient.builder().baseUrl(baseUrl).configureTimeouts(readTimeout, connectTimeout).build()
    }

    @Bean("luggageApi")
    fun luggageApi(luggageClient: WebClient) = LuggageAPI(luggageClient)


}