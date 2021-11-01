package com.andrii.model.models;

import com.andrii.model.annotation.*;
import lombok.*;

@Table(name = "weather_weekly_forecast")
@Data

public class WeatherWeeklyForecast extends GeneralModel {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "country_weakly_id")
    private Integer countryWeaklyId;

    @Column(name = "city_weakly_id")
    private Integer cityWeaklyId;

    @Column(name = "forecast_id")
    private Integer forecastId;

    @Column(name = "week_date")
    private String weekDate;

    @Column(name = "source_system")
    private String sourceSystem;
}
