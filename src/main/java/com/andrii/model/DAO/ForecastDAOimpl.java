package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.ForecastDAO;
import com.andrii.model.DAO.queries.QueryGenerator;

public class ForecastDAOimpl implements ForecastDAO {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Forecast");
        }
        return queryGenerator;
    }
}
