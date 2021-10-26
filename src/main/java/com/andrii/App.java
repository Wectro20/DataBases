package com.andrii;

import com.andrii.model.persistent.ConnectionManager;
import com.andrii.view.View;

import java.io.IOException;

import java.sql.SQLException;

public class App {
    public static void main(final String[] args) throws IOException, SQLException {
        View view = new View();
        view.print();
        ConnectionManager.closeConnection();
    }
}
