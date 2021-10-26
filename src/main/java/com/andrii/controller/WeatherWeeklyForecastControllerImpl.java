package com.andrii.controller;

import com.andrii.model.DAO.interfaces.GeneralDAO;
import com.andrii.model.DAO.WeatherWeeklyForecastDAOimpl;
import com.andrii.model.models.WeatherWeeklyForecast;
import com.andrii.controller.intefaces.WeatherWeeklyForecastController;

import java.util.Objects;

public class WeatherWeeklyForecastControllerImpl implements WeatherWeeklyForecastController {
    private GeneralDAO<WeatherWeeklyForecast, Integer> weatherWeeklyForecastDAO;

    @Override
    public GeneralDAO<WeatherWeeklyForecast, Integer> giveDAOobject() {
        return Objects.requireNonNullElseGet(weatherWeeklyForecastDAO, () -> weatherWeeklyForecastDAO = new WeatherWeeklyForecastDAOimpl());
    }
}
