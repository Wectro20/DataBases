package com.andrii.model.models;

import com.andrii.model.annotation.*;
import lombok.*;

@Table(name = "forecast")
@Data

public class Forecast extends GeneralModel {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "weather_status_id")
    private Integer weatherStatusId;

    @Column(name = "weather_warning_id")
    private Integer weatherWarningId;

    @Column(name = "day_id")
    private Integer dayId;

    @Column(name = "temperature")
    private Float temperature;

    @Column(name = "feels_like_temperature")
    private Float feelsLikeTemperature;

    @Column(name = "humidity_in_percentage")
    private Float humidityInPercentage;

    @Column(name = "wind_speed_in_mph")
    private Float windSpeedInMph;

    @Column(name = "wind_direction")
    private String windDirection;

    @Column(name = "date")
    private String date;

    @Column(name = "week_date")
    private String weekDate;
}
