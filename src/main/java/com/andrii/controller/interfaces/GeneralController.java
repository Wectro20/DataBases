package com.andrii.controller.interfaces;

import com.andrii.model.DAO.interfaces.GeneralDAO;

import java.sql.SQLException;
import java.util.List;

public interface GeneralController<T, ID> {
    GeneralDAO<T, ID> giveDAOobject();

    default List<T> findAll() throws SQLException {
        return giveDAOobject().findAll();
    }

    default T findById(ID id) throws SQLException {
        return giveDAOobject().findById(id);
    }

    default int create(T entity) throws SQLException {
        return giveDAOobject().create(entity);
    }

    default void update(T entity) throws SQLException {
        giveDAOobject().update(entity);
    }

    default int delete(ID id) throws SQLException {
        return giveDAOobject().delete(id);
    }

    String printColumns();
}
