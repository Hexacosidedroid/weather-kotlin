package ru.cib.weatherapi.dto

data class Wind (
        var speed: Double? = null,
        var deg: Long? = null,
        var gust: Double? = null
)