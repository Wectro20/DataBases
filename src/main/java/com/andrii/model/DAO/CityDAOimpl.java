package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.CityDAO;
import com.andrii.model.DAO.queries.QueryGenerator;

public class CityDAOimpl implements CityDAO {

    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("City");
        }
        return queryGenerator;
    }
}
