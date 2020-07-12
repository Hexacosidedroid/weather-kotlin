package ru.cib.weatherapi.dto

data class Sys (
        var type: Long? = null,
        var id: Long? = null,
        var country: String? = null,
        var sunrise: Long? = null,
        var sunset: Long? = null,
        var message: String? = null
)