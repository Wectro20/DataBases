package com.andrii.dto;

import com.andrii.models.Country;

public class CountryDto {
    private Country country;

    public CountryDto(Country country) {
        this.country = country;
    }

    public Integer getDaysId() {
        return country.getId();
    }

    public String getCountryName() {
        return country.getCountryName();
    }
}
