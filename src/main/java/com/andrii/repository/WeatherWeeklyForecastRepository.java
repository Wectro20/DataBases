package com.andrii.repository;

import com.andrii.models.WeatherWeeklyForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherWeeklyForecastRepository extends JpaRepository<WeatherWeeklyForecast, Integer> {
}
