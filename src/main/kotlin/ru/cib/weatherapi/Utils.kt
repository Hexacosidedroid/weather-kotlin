package ru.cib.weatherapi

import kotlin.math.floor

class Utils {
    fun toCelsius(temp: Double?) = (temp?.minus(273.00))?.times(100)?.let { floor(it) }?.div(100)
}