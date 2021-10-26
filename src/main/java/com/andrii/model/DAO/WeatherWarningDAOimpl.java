package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.WeatherWarningDAO;
import com.andrii.model.models.WeatherWarning;
import com.andrii.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeatherWarningDAOimpl implements WeatherWarningDAO {
    @Override
    public String FindAll() {
        return "SELECT * FROM weather_warning";
    }

    @Override
    public String FindOfElement() {
        return "SELECT * FROM weather_warning WHERE weather_warning.id = ?";
    }

    @Override
    public String Create() {
        return "INSERT weather_warning(name) VALUES (?)";
    }

    @Override
    public String Update() {
        return "Update weather_warning Set name=? WHERE id=?";
    }

    @Override
    public String Remove() {
        return "DELETE FROM weather_warning WHERE id=?";
    }

    @Override
    public WeatherWarning recordEntity(ResultSet resultSet) throws SQLException {
        return (WeatherWarning) new Transformer<>(WeatherWarning.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, WeatherWarning weatherWarning) throws SQLException {
        preparedStatement.setString(1, weatherWarning.getName());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, WeatherWarning weatherWarning) throws SQLException {
        preparedStatement.setInt(2, weatherWarning.getId());
        return preparedStatement;
    }
}
