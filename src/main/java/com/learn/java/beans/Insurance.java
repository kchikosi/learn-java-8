package com.learn.java.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Insurance {
    private String name;

    public Insurance(String name) {
        this.setName(name);
    }
}
