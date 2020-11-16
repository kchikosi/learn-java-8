package com.learn.java.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;
    private Optional<Person> personOptional;
    private Car car;
    private Insurance insurance;

    @BeforeEach
    void setUp() {
        person = new Person("Kotsanai", 55, Person.Gender.MALE);
        car = new  Car("Nissan Murano", "2016");
        insurance = new Insurance("Progressive");
        personOptional = Optional.of(person);
        assertNotNull(personOptional);
    }

    @Test
    void test_person_present() {
        assertEquals(Optional.of("Kotsanai"), personOptional.map(Person::getName));
    }

    @Test
    void test_this_person_has_no_car_hence_no_insurance() {
        assertThrows(NullPointerException.class, () -> personOptional.flatMap(Person::getCar));
        assertThrows(NullPointerException.class, () -> personOptional.flatMap(Person::getCar).flatMap(Car::getInsurance));
        assertThrows(NullPointerException.class, () -> personOptional.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName));
    }

    @Test
    void test_add_car() {
        person.setCar(Optional.ofNullable(car));
        assertTrue(personOptional.flatMap(Person::getCar).isPresent());
        assertEquals(Optional.of("Nissan Murano"), personOptional.flatMap(Person::getCar).map(Car::getModel));
    }

    @Test
    void test_add_insurance() {
        car.setInsurance(Optional.ofNullable(insurance));
        person.setCar(Optional.ofNullable(car));
        assertTrue(personOptional.flatMap(Person::getCar).flatMap(Car::getInsurance).isPresent());
        assertEquals(Optional.of("Progressive"), personOptional.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName));
    }

}