package com.app.conditionnal.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class User {
    @Size(min = 2)
    private String name;
    @Min(18)
    @Max(80)
    private int age;
}
