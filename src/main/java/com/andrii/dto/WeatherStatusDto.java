package com.andrii.dto;

import com.andrii.models.WeatherStatus;

public class WeatherStatusDto {
    private WeatherStatus weatherStatus;

    public WeatherStatusDto(WeatherStatus weatherStatus) {
        this.weatherStatus = weatherStatus;
    }

    public Integer getWeatherStatus() {
        return weatherStatus.getId();
    }

    public String getWeatherSt() {
        return weatherStatus.getWeatherSt();
    }
}
