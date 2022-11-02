package com.andrii.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "days", schema = "lab3")
public class Days{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @NotNull(message = "Missing name")
    @Column(name = "name")
    private String dayName;

    public Days(String name) {
        this.dayName = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Days days = (Days) o;
        return Objects.equals(id, days.id) && Objects.equals(dayName, days.dayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayName);
    }

    @Override
    public String toString() {
        return String.format("| %-3s| %-20s|",id, dayName);
    }


}
