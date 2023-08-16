package com.example.luggagesystembackofficeapi.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding


@ConfigurationProperties("kafka.topics")
data class KafkaTopicProperties(
    val luggageCreated: String
)