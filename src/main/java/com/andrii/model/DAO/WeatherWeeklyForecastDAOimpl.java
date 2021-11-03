package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.WeatherWeeklyForecastDAO;
import com.andrii.model.DAO.queries.QueryGenerator;

public class WeatherWeeklyForecastDAOimpl implements WeatherWeeklyForecastDAO {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("WeatherWeeklyForecast");
        }
        return queryGenerator;
    }
}
