package com.andrii.dto;

import com.andrii.models.City;
import com.andrii.models.Country;
import com.andrii.models.Forecast;
import com.andrii.models.WeatherWeeklyForecast;

import java.sql.Date;

public class WeatherWeeklyForecastDto {
    private WeatherWeeklyForecast weatherWeeklyForecast;

    public WeatherWeeklyForecastDto(WeatherWeeklyForecast weatherWeeklyForecast) {
        this.weatherWeeklyForecast = weatherWeeklyForecast;
    }

    public Integer getID() {
        return weatherWeeklyForecast.getId();
    }

    public Date getWeekDate() {
        return weatherWeeklyForecast.getWeekDate();
    }

    public String getSourceSystem() {
        return weatherWeeklyForecast.getSourceSystem();
    }

    public Country getCountryId() {
        return weatherWeeklyForecast.getCountryByCountryWeaklyId();
    }

    public City getCityId() {
        return weatherWeeklyForecast.getCityByCityWeaklyId();
    }

    public Forecast getForecastId() {
        return weatherWeeklyForecast.getForecastByForecastId();
    }
}
