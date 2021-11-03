package com.andrii.model.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "weather_weekly_forecast", schema = "lab3")
public class WeatherWeeklyForecast extends GeneralModel{
    private Integer id;
    private Date weekDate;
    private String sourceSystem;
    private Country countryByCountryWeaklyId;
    private City cityByCityWeaklyId;
    private Forecast forecastByForecastId;

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
    @Column(name = "week_date")
    public Date getWeekDate() {
        return weekDate;
    }

    public void setWeekDate(Date weekDate) {
        this.weekDate = weekDate;
    }

    @Basic
    @Column(name = "source_system")
    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
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

    @ManyToOne
    @JoinColumn(name = "country_weakly_id", referencedColumnName = "id", nullable = false)
    public Country getCountryByCountryWeaklyId() {
        return countryByCountryWeaklyId;
    }

    public void setCountryByCountryWeaklyId(Country countryByCountryWeaklyId) {
        this.countryByCountryWeaklyId = countryByCountryWeaklyId;
    }

    @ManyToOne
    @JoinColumn(name = "city_weakly_id", referencedColumnName = "id", nullable = false)
    public City getCityByCityWeaklyId() {
        return cityByCityWeaklyId;
    }

    public void setCityByCityWeaklyId(City cityByCityWeaklyId) {
        this.cityByCityWeaklyId = cityByCityWeaklyId;
    }

    @ManyToOne
    @JoinColumn(name = "forecast_id", referencedColumnName = "id", nullable = false)
    public Forecast getForecastByForecastId() {
        return forecastByForecastId;
    }

    public void setForecastByForecastId(Forecast forecastByForecastId) {
        this.forecastByForecastId = forecastByForecastId;
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s| %-20s| %-20s| %-20s|",id, countryByCountryWeaklyId, cityByCityWeaklyId, forecastByForecastId, weekDate, sourceSystem);
    }
}
