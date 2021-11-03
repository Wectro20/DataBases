package com.andrii.controller;

import com.andrii.controller.interfaces.ForecastController;
import com.andrii.model.DAO.ForecastDAOimpl;
import com.andrii.model.DAO.interfaces.GeneralDAO;
import com.andrii.model.models.Forecast;

import java.util.Objects;

public class ForecastControllerImpl implements ForecastController {
    private GeneralDAO<Forecast, Integer> forecastDAO;

    @Override
    public GeneralDAO<Forecast, Integer> giveDAOobject() {
        return Objects.requireNonNullElseGet(forecastDAO, () -> forecastDAO = new ForecastDAOimpl());
    }

    @Override
    public String printColumns() {
        return String.format("+----+-----------------+-----------------------+-----------------------+------------------+----------------+----------------+----------------+\n"+
                "| %-2s | %-15s | %-15s| %-15s| %-15s| %-15s| %-15s| %-15s| %-15s %-15s %-15s "+
                "\n+----+-----------------+-----------------------+-----------------------+------------------+----------------+----------------+----------------+"
                ,"id","temperature","feels_like_temperature","humidity_in_percentage","wind_speed_in_mph","wind_direction","date","week_date","day id", "weather_status_id", "weatherWarningId");
    }
}
