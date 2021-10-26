package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.ForecastDAO;
import com.andrii.model.models.Forecast;
import com.andrii.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForecastDAOimpl implements ForecastDAO {
    @Override
    public String FindAll() {
        return "SELECT * FROM forecast";
    }

    @Override
    public String FindOfElement() {
        return "SELECT * FROM forecast WHERE forecast.id = ?";
    }

    @Override
    public String Create() {
        return "INSERT forecast(weather_status_id, weather_warning_id, day_id, temperature, feels_like_temperature  " +
                "humidity_in_percentage, wind_speed_in_mph, wind_direction, date, week_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String Update() {
        return "UPDATE forecast SET weather_status_id=?, weather_warning_id=?, day_id, temperature=?, feels_like_temperature=?" +
                "humidity_in_percentage=?, wind_speed_in_mph=?, wind_direction=?, date=?, week_date=? WHERE id=?";
    }

    @Override
    public String Remove() {
        return "DELETE FROM forecast WHERE id=?";
    }

    @Override
    public Forecast recordEntity(ResultSet resultSet) throws SQLException {
        return (Forecast) new Transformer<>(Forecast.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Forecast forecast) throws SQLException {
        preparedStatement.setInt(1, forecast.getWeatherStatusId());
        preparedStatement.setInt(2, forecast.getWeatherWarningId());
        preparedStatement.setInt(3, forecast.getDayId());
        preparedStatement.setFloat(4, forecast.getTemperature());
        preparedStatement.setFloat(5, forecast.getFeelsLikeTemperature());
        preparedStatement.setFloat(6, forecast.getHumidityInPercentage());
        preparedStatement.setFloat(7, forecast.getWindSpeedInMph());
        preparedStatement.setString(8, forecast.getWindDirection());
        preparedStatement.setDate(9, forecast.getDate());
        preparedStatement.setDate(10, forecast.getWeekDate());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Forecast forecast) throws SQLException {
        preparedStatement.setInt(11, forecast.getId());
        return preparedStatement;
    }
}
