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
@Table(name = "forecast", schema = "lab3")
public class Forecast{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @NotNull(message = "Missing temperature")
    @Column(name = "temperature")
    private Double temperature;

    @Basic
    @NotNull(message = "Missing feelsLikeTemperature")
    @Column(name = "feels_like_temperature")
    private Double feelsLikeTemperature;

    @Basic
    @NotNull(message = "Missing humidityInPercentage")
    @Column(name = "humidity_in_percentage")
    private Double humidityInPercentage;

    @Basic
    @NotNull(message = "Missing windSpeedInMph")
    @Column(name = "wind_speed_in_mph")
    private Double windSpeedInMph;

    @Basic
    @NotNull(message = "Missing windDirection")
    @Column(name = "wind_direction")
    private String windDirection;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "week_date")
    private Date weekDate;

    @ManyToOne
    @NotNull(message = "Missing day id")
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Days dayId;

    @ManyToOne
    @NotNull(message = "Missing weather warning id")
    @JoinColumn(name = "weather_warning_id", referencedColumnName = "id")
    private WeatherWarning weatherWarningId;

    @ManyToOne
    @NotNull(message = "Missing weather status id")
    @JoinColumn(name = "weather_status_id", referencedColumnName = "id")
    private WeatherStatus weatherStatusId;

    public Forecast(Double temperature, Double feelsLikeTemperature, Double humidityInPercentage, Double windSpeedInMph,
                    String windDirection, Date date, Date weekDate, Days daysByDayId, WeatherWarning weatherWarningId,
                    WeatherStatus weatherStatusId) {
        this.temperature = temperature;
        this.feelsLikeTemperature = feelsLikeTemperature;
        this.humidityInPercentage = humidityInPercentage;
        this.windSpeedInMph = windSpeedInMph;
        this.windDirection = windDirection;
        this.date = date;
        this.weekDate = weekDate;
        this.dayId = daysByDayId;
        this.weatherWarningId = weatherWarningId;
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

    @Override
    public String toString() {
        return String.format("| %-3s| %-15s | %-22s| %-22s| %-17s| %-15s| %-15s| %-14s %-10s %-10s %-15s",id, temperature, feelsLikeTemperature, humidityInPercentage, windSpeedInMph, windDirection, date, weekDate, dayId, weatherStatusId, weatherWarningId);
    }
}
