package com.andrii.dto;

import com.andrii.models.WeatherWarning;

public class WeatherWarningDto {
    private WeatherWarning weatherWarning;

    public WeatherWarningDto(WeatherWarning weatherWarning) {
        this.weatherWarning = weatherWarning;
    }

    public Integer getWeatherWarningId() {
        return weatherWarning.getId();
    }

    public String getWeatherWarningName() {
        return weatherWarning.getWeatherWarningName();
    }
}
