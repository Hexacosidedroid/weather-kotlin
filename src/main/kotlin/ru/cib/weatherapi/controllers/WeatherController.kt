package ru.cib.weatherapi.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.cib.weatherapi.Task

@RestController
class WeatherController(
        val task: Task
) {

    @GetMapping("/getRostovWeather")
    fun getRostovWeather() = task.getCurrentWearher()
}