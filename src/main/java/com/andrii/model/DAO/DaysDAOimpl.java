package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.DaysDAO;
import com.andrii.model.models.Days;
import com.andrii.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaysDAOimpl implements DaysDAO {
    @Override
    public String FindAll() {
        return "SELECT * FROM days";
    }

    @Override
    public String FindOfElement() {
        return "SELECT * FROM days WHERE days.id = ?";
    }

    @Override
    public String Create() {
        return "INSERT days(name) VALUES (?)";
    }

    @Override
    public String Update() {
        return "Update days Set name=? WHERE id=?";
    }

    @Override
    public String Remove() {
        return "DELETE FROM days WHERE id=?";
    }

    @Override
    public Days recordEntity(ResultSet resultSet) throws SQLException {
        return (Days) new Transformer<>(Days.class).extractDataToModel(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Days days) throws SQLException {
        preparedStatement.setString(1, days.getName());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Days days) throws SQLException {
        preparedStatement.setInt(2, days.getId());
        return preparedStatement;
    }
}
