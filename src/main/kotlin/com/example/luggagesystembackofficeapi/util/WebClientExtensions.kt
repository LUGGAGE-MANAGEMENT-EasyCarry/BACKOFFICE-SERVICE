package com.example.luggagesystembackofficeapi.util

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import java.time.Duration
import java.util.concurrent.TimeUnit

inline fun WebClient.Builder.configureTimeouts(
    connectTimeout: Duration,
    readTimeout: Duration,
    httpClientCustomizer: HttpClient.() -> HttpClient = { this }
): WebClient.Builder {
    return clientConnector(
        ReactorClientHttpConnector(
            HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeout.toMillis().toInt())
                .doOnConnected { it.addHandlerLast(ReadTimeoutHandler(readTimeout.toMillis(), TimeUnit.MILLISECONDS)) }
                .httpClientCustomizer()
        )
    )
}



