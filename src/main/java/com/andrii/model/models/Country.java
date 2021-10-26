package com.andrii.model.models;

import com.andrii.model.annotation.*;
import lombok.*;

@Table(name = "country")
@Data

public class Country {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
