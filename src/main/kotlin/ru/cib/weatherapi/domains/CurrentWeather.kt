package ru.cib.weatherapi.domains

data class CurrentWeather (
        var id: Long? = null,
        var city_name: String? = null,
        var temp: Double? = null,
        var feels_like_temp: Double? = null,
        var pressure: Long? = null,
        var humidity: Long? = null,
        var weather: String? = null,
        var clouds: Long? = null,
        var wind_speed: Double? = null
)