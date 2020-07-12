package ru.cib.weatherapi.dto

data class Weather (
        var id: Long? = null,
        var main: String? = null,
        var description: String? = null,
        var icon: String? = null
)