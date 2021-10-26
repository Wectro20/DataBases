package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.WeatherStatusDAO;
import com.andrii.model.models.WeatherStatus;
import com.andrii.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeatherStatusDAOimpl implements WeatherStatusDAO {
    @Override
    public String FindAll() {
        return "SELECT * FROM weather_status";
    }

    @Override
    public String FindOfElement() {
        return "SELECT * FROM weather_status WHERE weather_status.id = ?";
    }

    @Override
    public String Create() {
        return "INSERT weather_status(name) VALUES (?)";
    }

    @Override
    public String Update() {
        return "Update weather_status Set name=? WHERE id=?";
    }

    @Override
    public String Remove() {
        return "DELETE FROM weather_status WHERE id=?";
    }

    @Override
    public WeatherStatus recordEntity(ResultSet resultSet) throws SQLException {
        return (WeatherStatus) new Transformer<>(WeatherStatus.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, WeatherStatus weatherStatus) throws SQLException {
        preparedStatement.setString(1, weatherStatus.getWeatherSt());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, WeatherStatus weatherStatus) throws SQLException {
        preparedStatement.setInt(2, weatherStatus.getId());
        return preparedStatement;
    }
}
