package com.learn.java;

import com.learn.java.beans.Person;
import com.learn.java.enums.Gender;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
//test comment
public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        people.forEach(System.out::println);

        //filter
        System.out.println("=== FEMALES ===");
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        //sort
        System.out.println("=== SORTED BY AGE ===");
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);

        //all match, returns boolean
        System.out.println("=== ALL MATCH ===");
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() <= 55);
        System.out.println(allMatch);
        //any match, returns boolean
        System.out.println("=== ANY MATCH ===");
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() == 100);
        System.out.println(anyMatch);
        //none match, returns boolean
        System.out.println("=== NONE MATCH ===");
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("John"));
        System.out.println(noneMatch);
        //max
        System.out.println("=== MAX ===");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        //min
        System.out.println("=== MIN ===");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        //group
        System.out.println("=== GROUP BY ===");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        //putting it all together
        //find oldest female's name
        System.out.println("=== THE OLDEST FEMALE ===");
        Optional<String> oldestFemale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
//        System.out.println(oldestFemale);
        oldestFemale.ifPresent(System.out::println);
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Kotsanai", 55, Gender.MALE),
                new Person("Anna", 45, Gender.FEMALE),
                new Person("Jonathan", 26, Gender.MALE),
                new Person("Fungai", 23, Gender.FEMALE),
                new Person("Johannes", 16, Gender.MALE)
        );
    }
}
