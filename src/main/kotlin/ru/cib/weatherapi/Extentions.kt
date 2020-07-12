package ru.cib.weatherapi

import ru.cib.weatherapi.dto.CurrentWeatherResponse
import ru.cib.weatherapi.dto.ShortCurrentWeatherResponse
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.math.floor


fun CurrentWeatherResponse.toShortResponse(): ShortCurrentWeatherResponse {
    val current = this
    return ShortCurrentWeatherResponse()
            .apply {
                current_time = current.dt?.let { Date(it*1000) }
                city_name = current.name
                temp = ((current.main?.temp?.minus(273.00))?.times(100)?.let { floor(it) }?.div(100))
                feels_like_temp = ((current.main?.feels_like?.minus(273.00))?.times(100)?.let { floor(it) }?.div(100))
                pressure = current.main?.pressure
                humidity = current.main?.humidity
                weather = current.weather?.get(0)?.description
                clouds = current.clouds?.all
                wind_speed = current.wind?.speed
                wind_direction = when {
                    current.wind?.deg!!<45 -> "North"
                    current.wind?.deg!!<135 -> "West"
                    current.wind?.deg!!<225 -> "South"
                    current.wind?.deg!!<315 -> "East"
                    current.wind?.deg!!<360 -> "North"
                    else -> "unreachable statement"
                }
            }
}
