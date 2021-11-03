package com.andrii.controller;

import com.andrii.controller.interfaces.CityController;
import com.andrii.model.models.City;
import com.andrii.model.DAO.CityDAOimpl;
import com.andrii.model.DAO.interfaces.GeneralDAO;

import java.util.Objects;

public class CityControllerImpl implements CityController {
    private GeneralDAO<City, Integer> cityDAO;

    @Override
    public GeneralDAO<City, Integer> giveDAOobject() {
        return Objects.requireNonNullElseGet(cityDAO, () -> cityDAO = new CityDAOimpl());
    }
}
