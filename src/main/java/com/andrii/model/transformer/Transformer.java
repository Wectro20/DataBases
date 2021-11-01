package com.andrii.model.transformer;

import com.andrii.model.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet ;
import java.sql.SQLException;

public class Transformer<T> {
    private final Class<T> clazz;

    public Transformer(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Object extractDataToModel(ResultSet rs) throws SQLException {
        Object model = null;
        try {
            model = clazz.getConstructor().newInstance();
            if (clazz.isAnnotationPresent(Table.class)) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Column.class)) {
                        Column column = field.getAnnotation(Column.class);
                        String name = column.name();
                        String type = field.getType().toString();
                        field.setAccessible(true);
                        switch (type) {
                            case "class java.lang.Integer":
                                field.set(model, rs.getInt(name));
                                break;
                            case "class java.lang.String":
                                field.set(model, rs.getString(name));
                                break;
                            case "class java.lang.Float":
                                field.set(model, rs.getFloat(name));
                                break;
                            case "class java.sql.Date":
                                field.set(model, rs.getDate(name));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException
                | NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}
