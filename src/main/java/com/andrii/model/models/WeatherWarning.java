package com.andrii.model.models;

import com.andrii.model.annotation.*;
import lombok.*;

@Table(name = "weather_warning")
@Data

public class WeatherWarning {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}

