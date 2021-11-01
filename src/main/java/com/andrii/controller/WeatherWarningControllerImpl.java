package com.andrii.controller;

import com.andrii.model.DAO.interfaces.GeneralDAO;
import com.andrii.model.DAO.WeatherWarningDAOimpl;
import com.andrii.model.models.WeatherWarning;
import com.andrii.controller.intefaces.WeatherWarningController;

import java.util.Objects;

public class WeatherWarningControllerImpl implements WeatherWarningController {
    private GeneralDAO<WeatherWarning, Integer> weatherWarningDAO;

    @Override
    public GeneralDAO<WeatherWarning, Integer> giveDAOobject() {
        return Objects.requireNonNullElseGet(weatherWarningDAO, () -> weatherWarningDAO = new WeatherWarningDAOimpl());
    }
}
