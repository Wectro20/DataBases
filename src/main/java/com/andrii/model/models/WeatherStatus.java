package com.andrii.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "weather_status", schema = "lab3")
public class WeatherStatus extends GeneralModel{
    private Integer id;
    private String weatherSt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "weather_st")
    public String getWeatherSt() {
        return weatherSt;
    }

    public void setWeatherSt(String weatherSt) {
        this.weatherSt = weatherSt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherStatus that = (WeatherStatus) o;
        return Objects.equals(id, that.id) && Objects.equals(weatherSt, that.weatherSt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weatherSt);
    }

    @Override
    public String toString() {
        return String.format("| %-3s| %-20s|",id, weatherSt);
    }

    @Override
    public String printColumns() {
        return String.format("+----+---------------------+\n| %-2s | %-19s |\n+----+---------------------+","id","weather status");
    }
}
