package com.andrii.dto;

import com.andrii.models.Days;

public class DaysDto {
    private Days days;

    public DaysDto(Days days) {
        this.days = days;
    }

    public Integer getDaysId() {
        return days.getId();
    }

    public String getDayName() {
        return days.getDayName();
    }
}
