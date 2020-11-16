package com.learn.java.streams;
/* A binary gap within a positive integer N is any maximal sequence of consecutive zeros
that is surrounded by ones at both ends in the binary representation of N.*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class BinaryGap {
    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        BinaryGap b = new BinaryGap();
        // import data from text file
        String file = "C://Users//krcch//Downloads//numbers.txt";
        Stream<String> numbers = null;
        try {
            numbers = Files.lines(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        numbers.forEach(b::solution);
    }

    public void solution(String n) {
        // write your code in Java SE 8 ...
        String binaryString = Integer.toBinaryString(Integer.parseInt(n));
        System.out.println("\nNumber :" + n + " " + "\nBinary string value: " + binaryString);

        String[] sequence = Arrays.stream(binaryString.split("1"))
                .map(String::trim)
                .filter(f -> f.length() > 0)
                .toArray(String[]::new);
        Stream<String> stream = Stream.of(sequence);
        System.out.print("Sequence list : ");
        stream.forEach(s -> System.out.print(s + " ")); //string format

        System.out.print("\nLongest sequence is: ");
        Optional<Integer> longestSequence = Arrays.stream(sequence)
                .map(String::length)
                .max(Integer::compareTo);
        longestSequence.ifPresent(System.out::println);
    }
}
