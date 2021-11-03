package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.WeatherWarningDAO;
import com.andrii.model.DAO.queries.QueryGenerator;

public class WeatherWarningDAOimpl implements WeatherWarningDAO {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("WeatherWarning");
        }
        return queryGenerator;
    }
}
