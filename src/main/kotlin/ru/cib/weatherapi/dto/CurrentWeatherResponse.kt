package ru.cib.weatherapi.dto

data class CurrentWeatherResponse (
        var coord: Coordinates? = null,
        var weather: MutableList<Weather>? = mutableListOf(),
        var base: String? = null,
        var main: Main? = null,
        var wind: Wind? = null,
        var clouds: Clouds? = null,
        var rain: Rain? = null,
        var snow: Snow? = null,
        var dt: Long? = null,
        var sys: Sys? = null,
        var timezone: Long? = null,
        var id: Long? = null,
        var name: String? = null,
        var cod: Long? = null
)