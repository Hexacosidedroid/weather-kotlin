package ru.cib.weatherapi.service

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.cib.weatherapi.dto.CurrentWeatherResponse
import ru.cib.weatherapi.toShortResponse

private val logger = KotlinLogging.logger {}

@Service
class WeatherService() {
    @Value("\${key}")
    val key: String? = null

    fun getCityWeather(city: String) = RestTemplate()
            .exchange("https://api.openweathermap.org/data/2.5/weather?q={city}&appid={key}",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    CurrentWeatherResponse::class.java,
                    city,
                    key
            ).body?.toShortResponse()
}