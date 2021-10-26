package com.andrii.view;

import com.andrii.controller.*;
import com.andrii.controller.intefaces.GeneralController;


import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View implements Printable {
    private final Map<String, GeneralController> tables;
    private String consoleInput;
    private Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);
    boolean isQuit;

    public View() {
        isQuit = false;
        tables = new HashMap<>();
        tables.put("City", new CityControllerImpl());
        tables.put("Country", new CountryControllerImpl());
        tables.put("Days", new DaysControllerImpl());
        tables.put("Forecast", new ForecastControllerImpl());
        tables.put("WeatherStatus", new WeatherStatusControllerImpl());
        tables.put("WeatherWarning", new WeatherWarningControllerImpl());
        tables.put("WeatherWeeklyForecast", new WeatherWeeklyForecastControllerImpl());
    }

    @Override
    public void print() {
        while (!isQuit) {
            try {
                System.out.println("    SELECTION MENU    ");
                System.out.println(getTables());
                consoleInput = input.nextLine().toUpperCase();
                switch (consoleInput) {
                    case "CT" -> printMethod("City");
                    case "CR" -> printMethod("Country");
                    case "D" -> printMethod("Days");
                    case "F" -> printMethod("Forecast");
                    case "WS" -> printMethod("WeatherStatus");
                    case "WW" -> printMethod("WeatherWarning");
                    case "WWF" -> printMethod("WeatherWeeklyForecast");
                    case "Q" -> isQuit = true;
                    default -> System.out.println("invalid input");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void printMethod(String table) throws SQLException {
        boolean isBack = false;
        while (!isBack) {
            System.out.println(getMethodModel(table));
            consoleInput = input.nextLine().toUpperCase();
            switch (consoleInput) {
                case "FA":
                    printFindAll(tables.get(table));
                    break;
                case "FBI":

                    break;
                case "C":

                    break;
                case "U":

                    break;
                case "F":

                    break;
                case "B":
                    isBack = true;
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }

    private String getTables() {
        StringBuffer str = new StringBuffer();
        str.append("    CT - City\n");
        str.append("    CR - Country\n");
        str.append("    D - Days\n");
        str.append("    F - Forecast\n");
        str.append("    WS - WeatherStatus\n");
        str.append("    WW - WeatherWarning\n");
        str.append("    WWF - WeatherWeeklyForecast\n");
        str.append("    Q - quit\n");
        return str.toString();
    }

    private String getMethodModel(String table) {
        StringBuffer str = new StringBuffer();
        str.append(table + "\n");
        str.append("    FA - Find All\n");
        str.append("    FBI - Find by id\n");
        str.append("    C - Create\n");
        str.append("    U - Update\n");
        str.append("    D - Delete\n");
        str.append("    B - back\n");
        return str.toString();
    }

    private void findById(GeneralController module) throws SQLException {
        System.out.println("Print id of model:");
        consoleInput = input.nextLine();
        System.out.println(module.findById(Integer.parseInt(consoleInput)));
    }

    private void printFindAll(GeneralController module) throws SQLException {
        for (Object a : module.findAll()) {
            System.out.println(a);
        }
    }

    private void create(GeneralController module) throws SQLException {

    }

    private void update() throws SQLException {

    }

    private void delete(GeneralController module) throws SQLException {

    }
}
