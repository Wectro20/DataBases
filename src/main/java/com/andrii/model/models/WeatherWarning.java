package com.andrii.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "weather_warning", schema = "lab3")
public class WeatherWarning extends GeneralModel{
    private Integer id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherWarning that = (WeatherWarning) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return String.format("| %-3s| %-29s|",id, name);
    }

    @Override
    public String printColumns() {
        return String.format("+----+------------------------------+\n| %-2s | %-28s |\n+----+------------------------------+","id","weather warning");
    }
}
