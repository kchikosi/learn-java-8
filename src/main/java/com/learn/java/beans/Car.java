package com.learn.java.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString
public class Car {
    private String model;
    private String year;
    private Optional<Insurance> insurance;

    public Car(String model, String year) {
        this.setModel(model);
        this.setYear(year);
    }
}
