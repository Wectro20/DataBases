package com.andrii.model.DAO.queries;

public class QueryGenerator {
    private final String className;

    public QueryGenerator(String className) {
        this.className = className;
    }

    public String FindAll() {
        return "FROM " + className;
    }

    public String FindById() {
        return String.format("FROM %s WHERE id = :id", className);
    }

    public String Delete() {
        return String.format("DELETE %s where id = :id", className);
    }
}
