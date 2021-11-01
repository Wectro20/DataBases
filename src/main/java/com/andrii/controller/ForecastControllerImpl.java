package com.andrii.controller;

import com.andrii.model.DAO.interfaces.GeneralDAO;
import com.andrii.model.DAO.ForecastDAOimpl;
import com.andrii.model.models.Forecast;
import com.andrii.controller.intefaces.ForecastController;

import java.util.Objects;

public class ForecastControllerImpl implements ForecastController {
    private GeneralDAO<Forecast, Integer> forecastDAO;

    @Override
    public GeneralDAO<Forecast, Integer> giveDAOobject() {
        return Objects.requireNonNullElseGet(forecastDAO, () -> forecastDAO = new ForecastDAOimpl());
    }
}
