package com.andrii.controller;

import com.andrii.controller.interfaces.WeatherWeeklyForecastController;
import com.andrii.model.DAO.WeatherWeeklyForecastDAOimpl;
import com.andrii.model.DAO.interfaces.GeneralDAO;
import com.andrii.model.models.WeatherWeeklyForecast;

import java.util.Objects;

public class WeatherWeeklyForecastControllerImpl implements WeatherWeeklyForecastController {
    private GeneralDAO<WeatherWeeklyForecast, Integer> weatherWeeklyForecastDAO;

    @Override
    public GeneralDAO<WeatherWeeklyForecast, Integer> giveDAOobject() {
        return Objects.requireNonNullElseGet(weatherWeeklyForecastDAO, () -> weatherWeeklyForecastDAO = new WeatherWeeklyForecastDAOimpl());
    }

    @Override
    public String printColumns() {
        return String.format("|%3s| %-20s | %-20s| %-20s| %-20s| %-20s|","id","country weakly id", "city weekly id", "forecast weekly id", "week date", "source system" );
    }
}
