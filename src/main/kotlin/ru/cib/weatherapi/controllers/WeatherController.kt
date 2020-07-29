package ru.cib.weatherapi.controllers

import org.springframework.web.bind.annotation.*
import ru.cib.weatherapi.domains.CurrentWeather
import ru.cib.weatherapi.repositories.WeatherHistoryRepository
import ru.cib.weatherapi.services.WeatherService

@RestController
class WeatherController(
        val weatherService: WeatherService,
        val weatherHistoryRepository: WeatherHistoryRepository
) {

    @GetMapping("/getWeather={city}")
    fun getRostovWeather(@PathVariable city: String) = weatherService.getCityWeather(city)

    @GetMapping("/getWeatherHistory")
    fun getWeatherHistory(): MutableList<CurrentWeather> = weatherHistoryRepository.findAll()
}