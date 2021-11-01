package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.CityDAO;
import com.andrii.model.models.City;
import com.andrii.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAOimpl implements CityDAO{
    @Override
    public String FindAll() {
        return "SELECT * FROM city";
    }

    @Override
    public String FindOfElement() {
        return "SELECT * FROM city WHERE city.id = ?";
    }

    @Override
    public String Create() {
        return "INSERT city(name) VALUES (?)";
    }

    @Override
    public String Update() {
        return "Update city Set name=? WHERE id=?";
    }

    @Override
    public String Remove() {
        return "DELETE FROM city WHERE id=?";
    }

    @Override
    public City recordEntity(ResultSet resultSet) throws SQLException {
        return (City) new Transformer<>(City.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, City city) throws SQLException {
        preparedStatement.setString(1, city.getName());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, City city) throws SQLException {
        preparedStatement.setInt(2, city.getId());
        return preparedStatement;
    }
}
