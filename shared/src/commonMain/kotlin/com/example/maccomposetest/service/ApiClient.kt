package com.example.maccomposetest.service


//import io.ktor.client.engine.cio.*

import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json

object ApiClient {
    val client: HttpClient by lazy {
        HttpClient() {
            install(ContentNegotiation) {
               json()
            }
//            install(Logging) {
//                level = LogLevel.BODY
//            }
            defaultRequest {
                header("X-Authy-APP-ID", "your_app_id")
                header("X-Authy-API-Key", "your_api_key")
            }
            HttpResponseValidator {
                handleResponseExceptionWithRequest { exception, request ->
                    when (exception) {
                        is ClientRequestException -> {
                            // Handle 4xx errors
                        }
                        is ServerResponseException -> {
                            // Handle 5xx errors
                        }
                        else -> {
                            // Handle other errors
                        }
                    }
                }
            }
        }
    }
}
