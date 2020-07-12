package ru.cib.weatherapi.dto

data class Main (
        var temp: Double? = null,
        var feels_like: Double? = null,
        var temp_min: Double? = null,
        var temp_max: Double? = null,
        var pressure: Long? = null,
        var humidity: Long? = null,
        var sea_level: Double? = null,
        var grnd_level: Double? = null
)