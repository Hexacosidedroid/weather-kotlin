package ru.cib.weatherapi

import ru.cib.weatherapi.domains.CurrentWeather
import ru.cib.weatherapi.dto.CurrentWeatherResponse
import ru.cib.weatherapi.dto.ShortCurrentWeatherResponse
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.math.floor

fun CurrentWeatherResponse.toDatabaseDomain(): CurrentWeather {
    val current = this
    return CurrentWeather()
            .apply {
                city_name = current.name
                temperature = Utils().toCelsius(current.main?.temp)
                feels_like_temp = Utils().toCelsius(current.main?.feels_like)
                pressure = current.main?.pressure
                humidity = current.main?.humidity
                weather = current.weather?.get(0)?.description
                clouds = current.clouds?.all
                wind_speed = current.wind?.speed
            }
}

fun CurrentWeatherResponse.toShortResponse(): ShortCurrentWeatherResponse {
    val current = this
    return ShortCurrentWeatherResponse()
            .apply {
                current_time = current.dt?.let { Date(it * 1000) }
                city_name = current.name
                temp = Utils().toCelsius(current.main?.temp)
                feels_like_temp = Utils().toCelsius(current.main?.feels_like)
                pressure = current.main?.pressure
                humidity = current.main?.humidity
                weather = current.weather?.get(0)?.description
                clouds = current.clouds?.all
                wind_speed = current.wind?.speed
                wind_direction = when {
                    current.wind?.deg!! < 45 -> "North"
                    current.wind?.deg!! < 135 -> "West"
                    current.wind?.deg!! < 225 -> "South"
                    current.wind?.deg!! < 315 -> "East"
                    current.wind?.deg!! < 360 -> "North"
                    else -> "unreachable statement"
                }
            }
}
