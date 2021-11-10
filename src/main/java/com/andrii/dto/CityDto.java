package com.andrii.dto;

import com.andrii.models.City;

public class CityDto {
    private City city;

    public CityDto(City city) {
        this.city = city;
    }

    public Integer getId() {
        return city.getId();
    }

    public String getCityName() {
        return city.getName();
    }
}
