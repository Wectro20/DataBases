package com.andrii.model.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Forecast extends GeneralModel{
    private Integer id;
    private Double temperature;
    private Double feelsLikeTemperature;
    private Double humidityInPercentage;
    private Double windSpeedInMph;
    private String windDirection;
    private Date date;
    private Date weekDate;
    private Days daysByDayId;
    private WeatherWarning weatherWarningId;
    private WeatherStatus weatherStatusId;

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
    @Column(name = "temperature")
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "feels_like_temperature")
    public Double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public void setFeelsLikeTemperature(Double feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    @Basic
    @Column(name = "humidity_in_percentage")
    public Double getHumidityInPercentage() {
        return humidityInPercentage;
    }

    public void setHumidityInPercentage(Double humidityInPercentage) {
        this.humidityInPercentage = humidityInPercentage;
    }

    @Basic
    @Column(name = "wind_speed_in_mph")
    public Double getWindSpeedInMph() {
        return windSpeedInMph;
    }

    public void setWindSpeedInMph(Double windSpeedInMph) {
        this.windSpeedInMph = windSpeedInMph;
    }

    @Basic
    @Column(name = "wind_direction")
    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "week_date")
    public Date getWeekDate() {
        return weekDate;
    }

    public void setWeekDate(Date weekDate) {
        this.weekDate = weekDate;
    }

    @ManyToOne
    @JoinColumn(name = "weather_warning_id", referencedColumnName = "id", nullable = false)
    public WeatherWarning getWeatherWarningId() {
        return weatherWarningId;
    }

    public void setWeatherWarningId(WeatherWarning weatherWarningId) {
        this.weatherWarningId = weatherWarningId;
    }

    @ManyToOne
    @JoinColumn(name = "weather_status_id", referencedColumnName = "id", nullable = false)
    public WeatherStatus getWeatherStatusId() {
        return weatherStatusId;
    }

    public void setWeatherStatusId(WeatherStatus weatherStatusId) {
        this.weatherStatusId = weatherStatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forecast forecast = (Forecast) o;
        return Objects.equals(id, forecast.id) && Objects.equals(temperature, forecast.temperature) && Objects.equals(feelsLikeTemperature, forecast.feelsLikeTemperature) && Objects.equals(humidityInPercentage, forecast.humidityInPercentage) && Objects.equals(windSpeedInMph, forecast.windSpeedInMph) && Objects.equals(windDirection, forecast.windDirection) && Objects.equals(date, forecast.date) && Objects.equals(weekDate, forecast.weekDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temperature, feelsLikeTemperature, humidityInPercentage, windSpeedInMph, windDirection, date, weekDate);
    }

    @ManyToOne
    @JoinColumn(name = "day_id", referencedColumnName = "id", nullable = false)
    public Days getDaysByDayId() {
        return daysByDayId;
    }

    public void setDaysByDayId(Days daysByDayId) {
        this.daysByDayId = daysByDayId;
    }

    @Override
    public String toString() {
        return String.format("| %-3s| %-15s | %-22s| %-22s| %-17s| %-15s| %-15s| %-15s %-15s %-15s %-15s",id, temperature, feelsLikeTemperature, humidityInPercentage, windSpeedInMph, windDirection, date, weekDate, daysByDayId, weatherStatusId, weatherWarningId);
    }
}
