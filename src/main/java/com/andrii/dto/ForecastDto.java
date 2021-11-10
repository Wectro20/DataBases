package com.andrii.dto;

import com.andrii.models.Days;
import com.andrii.models.Forecast;
import com.andrii.models.WeatherStatus;
import com.andrii.models.WeatherWarning;

import java.sql.Date;

public class ForecastDto {
    private Forecast forecast;

    public ForecastDto(Forecast forecast) {
        this.forecast = forecast;
    }

    public Integer getId() {
        return forecast.getId();
    }

    public Double getTemperature() {
        return forecast.getTemperature();
    }

    public Double getFeelsLikeTemperature() {
        return forecast.getFeelsLikeTemperature();
    }

    public Double getHumidityInPercentage() {
        return forecast.getHumidityInPercentage();
    }

    public Double getWindSpeedInMph() {
        return forecast.getWindSpeedInMph();
    }

    public String getWindDirection() {
        return forecast.getWindDirection();
    }

    public Date getDate() {
        return forecast.getDate();
    }

    public Date getWeekDate() {
        return forecast.getWeekDate();
    }

    public Days getDayId() {
        return forecast.getDayId();
    }

    public WeatherWarning getWeatherWarningId() {
        return forecast.getWeatherWarningId();
    }

    public WeatherStatus getWeatherStatusId() {
        return forecast.getWeatherStatusId();
    }
}
