package ru.cib.weatherapi.controllers

import org.springframework.web.bind.annotation.*
import ru.cib.weatherapi.service.WeatherService

@RestController
class WeatherController(
        val weatherService: WeatherService
) {

    @GetMapping("/getWeather={city}")
    fun getRostovWeather(@PathVariable city: String) = weatherService.getCityWeather(city)

//    @GetMapping("/getWeatherHistory")
//    fun getWeatherHistory() =
}