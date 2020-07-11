package ru.cib.weatherapi

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

private val logger = KotlinLogging.logger {}

@Service
class Task {
    @Value("\${city}")
    val city: String? = null

    @Value("\${key}")
    val key: String? = null

//    @Scheduled(fixedDelay = 600000L)
    fun getCurrentWearher(): String? {
        val httpEntity = HttpEntity.EMPTY
        val restTemplate = RestTemplate()
                .exchange("https://api.openweathermap.org/data/2.5/weather?q={city}&appid={key}",
                        HttpMethod.GET,
                        httpEntity,
                        String::class.java,
                        city,
                        key
                )
        return restTemplate.body
    }
}