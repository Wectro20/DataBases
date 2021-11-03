package com.andrii.model.DAO;

import com.andrii.model.DAO.interfaces.DaysDAO;
import com.andrii.model.DAO.queries.QueryGenerator;


public class DaysDAOimpl implements DaysDAO {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Days");
        }
        return queryGenerator;
    }
}
