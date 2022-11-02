package com.andrii.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather_status", schema = "lab3")
public class WeatherStatus{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @NotNull(message = "Missing weather status")
    @Column(name = "weather_st")
    private String weatherSt;

    public WeatherStatus(String weatherSt) {
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
}
