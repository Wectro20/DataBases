package com.andrii.model.models;

import com.andrii.model.annotation.*;
import lombok.*;

@Table(name = "weather_status")
@Data

public class WeatherStatus {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "weather_st")
    private String weatherSt;
}
