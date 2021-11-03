package com.andrii.controller;

import com.andrii.controller.interfaces.DaysController;
import com.andrii.model.DAO.DaysDAOimpl;
import com.andrii.model.DAO.interfaces.GeneralDAO;
import com.andrii.model.models.Days;

import java.util.Objects;

public class DaysControllerImpl implements DaysController {
    private GeneralDAO<Days, Integer> daysDAO;

    @Override
    public GeneralDAO<Days, Integer> giveDAOobject() {
        return Objects.requireNonNullElseGet(daysDAO, () -> daysDAO = new DaysDAOimpl());
    }

    @Override
    public String printColumns() {
        return String.format("+----+---------------------+\n| %-2s | %-19s |\n+----+---------------------+","id","days");
    }
}
