package com.andrii.model.DAO.interfaces;

import com.andrii.model.persistent.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface GeneralDAO<T, ID> {
    String FindAll();
    String FindOfElement();
    String Create();
    String Update();
    String Remove();

    T recordEntity(ResultSet resultSet) throws SQLException;
    PreparedStatement setParameters(PreparedStatement preparedStatement, T entity)
            throws SQLException;
    PreparedStatement setId(PreparedStatement preparedStatement, T entity) throws SQLException;
    default List<T> findAll() throws SQLException {
        List<T> entityList = new ArrayList<>();
        try (Statement statement = ConnectionManager.setConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(FindAll());
            while (resultSet.next()) {
                entityList.add(recordEntity(resultSet));
            }
            resultSet.close();
            return entityList;
        }
    }

    default T findById(ID id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionManager.setConnection().prepareStatement(FindOfElement())) {
            preparedStatement.setObject(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return recordEntity(resultSet);
                }
            }
        }
        return null;
    }

    default int create(T entity) throws SQLException {
        Connection connection = ConnectionManager.setConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(Create())) {
            PreparedStatement statement = setParameters(preparedStatement, entity);
            return statement.executeUpdate();
        }
    }

    default int update(T entity) throws SQLException {
        Connection connection = ConnectionManager.setConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(Update())) {
            PreparedStatement statement = setParameters(preparedStatement, entity);
            statement = setId(statement, entity);
            return statement.executeUpdate();
        }
    }

    default int delete(ID id) throws SQLException {
        Connection connection = ConnectionManager.setConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(Remove())) {
            preparedStatement.setObject(1, id);
            return preparedStatement.executeUpdate();
        }
    }
}
