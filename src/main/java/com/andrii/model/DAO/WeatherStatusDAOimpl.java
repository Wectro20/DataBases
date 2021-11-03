package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.WeatherStatusDAO;
import com.andrii.model.DAO.queries.QueryGenerator;

public class WeatherStatusDAOimpl implements WeatherStatusDAO {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("WeatherStatus");
        }
        return queryGenerator;
    }
}
