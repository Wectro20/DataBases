package com.andrii.view;

import com.andrii.controller.*;
import com.andrii.controller.interfaces.GeneralController;
import com.andrii.model.models.*;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View implements Printable {
    private final Map<String, GeneralController> tables;
    private final Map<String, GeneralModel> models;
    private String consoleInput;
    private Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);
    boolean isQuit;

    public View() {
        isQuit = false;
        models = new HashMap<>();
        tables = new HashMap<>();
        tables.put("City", new CityControllerImpl());
        tables.put("Country", new CountryControllerImpl());
        tables.put("Days", new DaysControllerImpl());
        tables.put("Forecast", new ForecastControllerImpl());
        tables.put("WeatherStatus", new WeatherStatusControllerImpl());
        tables.put("WeatherWarning", new WeatherWarningControllerImpl());
        tables.put("WeatherWeeklyForecast", new WeatherWeeklyForecastControllerImpl());
        models.put("City", new City());
        models.put("Country", new Country());
        models.put("Days", new Days());
        models.put("Forecast", new Forecast());
        models.put("WeatherStatus", new WeatherStatus());
        models.put("WeatherWarning", new WeatherWarning());
        models.put("WeatherWeeklyForecast", new WeatherWeeklyForecast());
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
                System.out.println("invalid input");
            }
        }
    }

    private void printMethod(String table) throws SQLException {
        boolean isBack = false;
        while (!isBack) {
            System.out.println(getMethodModel(table));
            consoleInput = input.nextLine().toUpperCase();
            switch (consoleInput) {
                case "FA" ->{
                    System.out.println(tables.get(table).printColumns());
                    printFindAll(tables.get(table));
                }
                case "FBI" -> findById(tables.get(table));
                case "C" -> create(tables.get(table), models.get(table));
                case "U" -> update(tables.get(table), models.get(table));
                case "D" -> delete(tables.get(table));
                case "B" -> isBack = true;
                default -> System.out.println("invalid input");
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

    private GeneralModel getModel(GeneralModel model, boolean isToUpdate) {
        try {
            model = model.getClass().getConstructor().newInstance();
            Field[] fields = model.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName() == "id" && !isToUpdate) {
                    continue;
                }
                System.out.println("Print value of " + field.getName() + " type " + field.getAnnotatedType() + ": ");
                consoleInput = input.nextLine();
                field.setAccessible(true);
                switch (field.getAnnotatedType().toString()) {
                    case "java.lang.Integer" -> field.set(model, Integer.parseInt(consoleInput));
                    case "java.lang.String" -> field.set(model, consoleInput);
                    case "java.lang.Float" -> field.set(model, Float.parseFloat(consoleInput));
                    default -> {
                    }
                }
            }
            return model;
        } catch (Exception e) {
            System.out.println("bad input" + e);
        }
        return null;
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

    private void create(GeneralController controller, GeneralModel model) throws SQLException {
        controller.create(getModel(model,false));
        System.out.println("Success");
    }

    private void update(GeneralController module, GeneralModel model) throws SQLException {
        model = getModel(model,true);
        if(model == null){
            System.out.println("Bad input");
        }else {
            module.update(model);
            System.out.println("Success");
        }
    }

    private void delete(GeneralController module) throws SQLException {
        System.out.println("Print id of model to delete:");
        consoleInput = input.nextLine();
        System.out.println("Success");
        System.out.println(module.delete(Integer.parseInt(consoleInput)));
    }
}
