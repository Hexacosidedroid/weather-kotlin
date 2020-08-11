package ru.cib.weatherapi.tasks

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.cib.weatherapi.domains.CurrentWeather
import ru.cib.weatherapi.dto.CurrentWeatherResponse
//import ru.cib.weatherapi.mail.MailNotifier
import ru.cib.weatherapi.repositories.WeatherHistoryRepository
import ru.cib.weatherapi.toDatabaseDomain

private val logger = KotlinLogging.logger {}

@Service
class Task(
        val weatherHistoryRepository: WeatherHistoryRepository
//        val mailNotifier: MailNotifier
) {
    @Value("\${city}")
    val city: String? = null
    @Value("\${key}")
    val key: String? = null

    @Scheduled(cron = "0 0/10 * * * ?")
    fun getCurrentWeather() {
        logger.debug("starting download current weather")
        val restTemplate = RestTemplate()
                .exchange("https://api.openweathermap.org/data/2.5/weather?q={city}&appid={key}",
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        CurrentWeatherResponse::class.java,
                        city,
                        key
                )
        logger.debug("received response ${restTemplate.body}")
        val weather = restTemplate.body?.toDatabaseDomain()
        logger.debug("saving current weather response")
        weatherHistoryRepository.save(weather!!)
    }

//    @Scheduled(cron = "0 0/5 * * * ?")
//    fun monitoringWeather() {
//        logger.debug("starting weather monitoring")
//        val count = weatherHistoryRepository.count()
//        val currentWeather = weatherHistoryRepository.findById(count)
//        val currentWeather = weatherHistoryRepository.findTopByOrderByIdDesc()
//        val curWeather = currentWeather.get()
//        when (curWeather.weather) {
//            "moderate rain" -> mailNotifier.sendMail(curWeather.weather!!, "..@mail.com")
//            "Snow" -> mailNotifier.sendMail(curWeather.weather!!, "..@mail.com")
//            "mist" -> mailNotifier.sendMail(curWeather.weather!!, "..@mail.com")
//            "thunderstorm" -> mailNotifier.sendMail(curWeather.weather!!, "..@mail.com")
//        }
//        when {
//            curWeather.temperature!! > 35 ->
//                mailNotifier.sendMail("It's super hot now! Actual temp =  ${curWeather.temperature!!}",
//                        "..@mail.com")
//            curWeather.temperature!! < -15 ->
//                mailNotifier.sendMail("It's super cold now! Actual temp = ${curWeather.temperature!!}",
//                        "..@mail.com")
//        }
//    }
}