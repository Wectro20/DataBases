package com.andrii.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

import lombok.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather_weekly_forecast", schema = "lab3")
public class WeatherWeeklyForecast{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "week_date")
    private Date weekDate;

    @Basic
    @NotNull(message = "Missing source system")
    @Column(name = "source_system")
    private String sourceSystem;

    @ManyToOne
    @NotNull(message = "Missing country id")
    @JoinColumn(name = "country_weakly_id", referencedColumnName = "id", nullable = false)
    private Country countryByCountryWeaklyId;

    @ManyToOne
    @NotNull(message = "Missing city id")
    @JoinColumn(name = "city_weakly_id", referencedColumnName = "id", nullable = false)
    private City cityByCityWeaklyId;

    @ManyToOne
    @NotNull(message = "Missing city id")
    @JoinColumn(name = "forecast_id", referencedColumnName = "id", nullable = false)
    private Forecast forecastByForecastId;

    public WeatherWeeklyForecast(Date weekDate, String sourceSystem, Country countryByCountryWeaklyId,
                                 City cityByCityWeaklyId, Forecast forecastByForecastId) {
        this.weekDate = weekDate;
        this.sourceSystem = sourceSystem;
        this.countryByCountryWeaklyId = countryByCountryWeaklyId;
        this.cityByCityWeaklyId = cityByCityWeaklyId;
        this.forecastByForecastId = forecastByForecastId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherWeeklyForecast that = (WeatherWeeklyForecast) o;
        return Objects.equals(id, that.id) && Objects.equals(weekDate, that.weekDate) && Objects.equals(sourceSystem, that.sourceSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weekDate, sourceSystem);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s %-20s %-5s %-5s | %-14s|",id, countryByCountryWeaklyId, cityByCityWeaklyId, forecastByForecastId, weekDate, sourceSystem);
    }
}
