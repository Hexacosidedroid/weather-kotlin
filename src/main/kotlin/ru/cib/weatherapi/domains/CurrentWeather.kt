package ru.cib.weatherapi.domains

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "rostov_weather_history")
data class CurrentWeather (
        @field:Id
        @field:GeneratedValue(strategy= GenerationType.AUTO)
        var id: Long? = null,
        var city_name: String? = null,
        var temperature: Double? = null,
        var feels_like_temp: Double? = null,
        var pressure: Long? = null,
        var humidity: Long? = null,
        var weather: String? = null,
        var clouds: Long? = null,
        var wind_speed: Double? = null,
        @field:CreationTimestamp
        var cr_dt: Date? = null
)