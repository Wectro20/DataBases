package com.andrii.controller;

import com.andrii.model.DAO.interfaces.GeneralDAO;
import com.andrii.model.DAO.CountryDAOimpl;
import com.andrii.model.models.Country;
import com.andrii.controller.intefaces.CountryController;

import java.util.Objects;

public class CountryControllerImpl implements CountryController {
    private GeneralDAO<Country, Integer> countryDAO;

    @Override
    public GeneralDAO<Country, Integer> giveDAOobject() {
        return Objects.requireNonNullElseGet(countryDAO, () -> countryDAO = new CountryDAOimpl());
    }
}
