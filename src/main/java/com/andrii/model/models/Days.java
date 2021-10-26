package com.andrii.model.models;

import com.andrii.model.annotation.*;
import lombok.*;

@Table(name = "days")
@Data

public class Days {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
