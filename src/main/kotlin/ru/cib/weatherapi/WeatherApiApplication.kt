package ru.cib.weatherapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class WeatherApiApplication

fun main() {
	SpringApplication.run(WeatherApiApplication::class.java)
}
