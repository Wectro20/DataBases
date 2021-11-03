package com.andrii.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class City extends GeneralModel{
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
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return String.format("| %-3s| %-20s|",id, name);
    }

    @Override
    public String printColumns() {
        return String.format("+----+---------------------+\n| %-2s | %-19s |\n+----+---------------------+","id","city name");
    }
}
