package ru.cib.weatherapi.tasks

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.cib.weatherapi.dto.CurrentWeatherResponse
import ru.cib.weatherapi.repositories.WeatherHistoryRepository
import ru.cib.weatherapi.toDatabaseDomain

private val logger = KotlinLogging.logger {}

@Service
class Task(
        val weatherHistoryRepository: WeatherHistoryRepository
) {
    @Value("\${city}")
    val city: String? = null
    @Value("\${key}")
    val key: String? = null

    //    @Scheduled(fixedDelay = 60000L)
    @Scheduled(cron = "0 0/10 * * * ?")
    fun getCurrentWeather() {
        val restTemplate = RestTemplate()
                .exchange("https://api.openweathermap.org/data/2.5/weather?q={city}&appid={key}",
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        CurrentWeatherResponse::class.java,
                        city,
                        key
                )
        val result = weatherHistoryRepository.save(restTemplate.body?.toDatabaseDomain())
    }
}