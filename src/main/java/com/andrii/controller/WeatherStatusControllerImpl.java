package com.andrii.controller;

import com.andrii.controller.interfaces.WeatherStatusController;
import com.andrii.model.DAO.WeatherStatusDAOimpl;
import com.andrii.model.DAO.interfaces.GeneralDAO;
import com.andrii.model.models.WeatherStatus;

import java.util.Objects;

public class WeatherStatusControllerImpl implements WeatherStatusController {
    private GeneralDAO<WeatherStatus, Integer> weatherStatusDAO;

    @Override
    public GeneralDAO<WeatherStatus, Integer> giveDAOobject() {
        return Objects.requireNonNullElseGet(weatherStatusDAO, () -> weatherStatusDAO = new WeatherStatusDAOimpl());
    }

    @Override
    public String printColumns() {
        return String.format("+----+---------------------+\n| %-2s | %-19s |\n+----+---------------------+","id","weather status");
    }
}
