package com.andrii.controller;

import com.andrii.model.DAO.interfaces.GeneralDAO;
import com.andrii.model.DAO.DaysDAOimpl;
import com.andrii.model.models.Days;
import com.andrii.controller.intefaces.DaysController;

import java.util.Objects;

public class DaysControllerImpl implements DaysController {
    private GeneralDAO<Days, Integer> daysDAO;

    @Override
    public GeneralDAO<Days, Integer> giveDAOobject() {
        return Objects.requireNonNullElseGet(daysDAO, () -> daysDAO = new DaysDAOimpl());
    }
}
