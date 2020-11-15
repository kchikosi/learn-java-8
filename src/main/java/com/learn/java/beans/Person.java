package com.learn.java.beans;

import com.learn.java.enums.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString
public class Person {
    private String name;
    private int age;
    private Gender gender;
    public Optional<Car> car;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
