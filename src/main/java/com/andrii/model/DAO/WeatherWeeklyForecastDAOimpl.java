package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.WeatherWeeklyForecastDAO;
import com.andrii.model.models.WeatherWeeklyForecast;
import com.andrii.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class WeatherWeeklyForecastDAOimpl implements WeatherWeeklyForecastDAO {
    @Override
    public String FindAll() {
        return "SELECT * FROM weather_weekly_forecast";
    }

    @Override
    public String FindOfElement() {
        return "SELECT * FROM weather_weekly_forecast WHERE weather_weekly_forecast.id = ?";
    }

    @Override
    public String Create() {
        return "INSERT weather_weekly_forecast(country_weakly_id, city_weakly_id, forecast_id,week_date, source_system) VALUES (?,?,?,?,?)";
    }

    @Override
    public String Update() {
        return "UPDATE weather_weekly_forecast SET country_weakly_id=?, city_weakly_id=?, forecast_id=?, week_date=?, source_system=? WHERE id=?";
    }

    @Override
    public String Remove() {
        return "DELETE FROM weather_weekly_forecast WHERE id=?";
    }

    @Override
    public WeatherWeeklyForecast recordEntity(ResultSet resultSet) throws SQLException {
        return (WeatherWeeklyForecast) new Transformer<>(WeatherWeeklyForecast.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, WeatherWeeklyForecast weatherWeeklyForecast) throws SQLException {
        preparedStatement.setInt(1, weatherWeeklyForecast.getCountryWeaklyId());
        preparedStatement.setInt(2, weatherWeeklyForecast.getCityWeaklyId());
        preparedStatement.setInt(3, weatherWeeklyForecast.getForecastId());
        preparedStatement.setString(4, weatherWeeklyForecast.getWeekDate());
        preparedStatement.setString(5, weatherWeeklyForecast.getSourceSystem());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, WeatherWeeklyForecast weatherWeeklyForecast) throws SQLException {
        preparedStatement.setInt(6, weatherWeeklyForecast.getId());
        return preparedStatement;
    }
}
