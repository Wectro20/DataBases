package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.CountryDAO;
import com.andrii.model.models.Country;
import com.andrii.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAOimpl implements CountryDAO{

    @Override
    public String FindAll() {
        return "SELECT * FROM country";
    }

    @Override
    public String FindOfElement() {
        return "SELECT * FROM country WHERE country.id = ?";
    }

    @Override
    public String Create() {
        return "INSERT country(name) VALUES (?)";
    }

    @Override
    public String Update() {
        return "Update country Set name=? WHERE id=?";
    }

    @Override
    public String Remove() {
        return "DELETE FROM country WHERE id=?";
    }

    @Override
    public Country recordEntity(ResultSet resultSet) throws SQLException {
        return (Country) new Transformer<>(Country.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Country country) throws SQLException {
        preparedStatement.setString(1, country.getName());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Country country) throws SQLException {
        preparedStatement.setInt(2, country.getId());
        return preparedStatement;
    }
}
