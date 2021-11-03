package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.CountryDAO;
import com.andrii.model.DAO.queries.QueryGenerator;

public class CountryDAOimpl implements CountryDAO{

    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Country");
        }
        return queryGenerator;
    }
}
