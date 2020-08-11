package ru.cib.weatherapi.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.cib.weatherapi.domains.CurrentWeather

@Repository
interface WeatherHistoryRepository : JpaRepository<CurrentWeather, Long> {
    fun findTopByOrderByIdDesc(): CurrentWeather
}