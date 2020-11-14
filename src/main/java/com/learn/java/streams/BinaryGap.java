package com.learn.java.streams;
/* A binary gap within a positive integer N is any maximal sequence of consecutive zeros
that is surrounded by ones at both ends in the binary representation of N.*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.*;

public class BinaryGap {
    public static void main(String[] args) {
        BinaryGap b = new BinaryGap();
//        import data from text file
        String file = "C://Users//krcch//Downloads//numbers.txt";
        Stream<String> numbers = null;
        try {
            numbers = Files.lines(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        numbers.forEach(n -> b.solution(n));
    }

    public void solution(String n) {
        // write your code in Java SE 8 ...
        String binaryString = Integer.toBinaryString(Integer.parseInt(n));
        System.out.println("\nNumber :" + n + " " + "\nBinary string value: " + binaryString);

        String[] sequence = Arrays.stream(binaryString.split("1"))
                .map(String::trim)
                .filter(f -> f.length() > 0)
                .toArray(String[]::new);
        Stream stream = Stream.of(sequence);
        System.out.print("Sequence list : ");
        stream.forEach(s -> System.out.print(s +" ")); //string format

        int max = Arrays.asList(sequence)
                .stream()
                .map(String::length)
                .max(Integer::compareTo)
                .get();
        System.out.println("\nMax is: " + max);
    }
}
