package ru.cib.weatherapi.dto

import java.util.Date

data class ShortCurrentWeatherResponse (
        var current_time: Date? = null,
        var city_name: String? = null,
        var temp: Double? = null,
        var feels_like_temp: Double? = null,
        var pressure: Long? = null,
        var humidity: Long? = null,
        var weather: String? = null,
        var clouds: Long? = null,
        var wind_speed: Double? = null,
        var wind_direction: String? = null
)