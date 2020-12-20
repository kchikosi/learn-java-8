package com.learn.java.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class StreamUtilsTest {

    @Test
    void toCharStream() {
        String[] arrayOfWords = {"Goodbye", "World"};
        List<String> words = Arrays.asList(arrayOfWords);
        List<String[]> words2 = words.stream().map(w -> w.split("")).collect(Collectors.toList());
        words2.stream().forEach(System.out::println);

        List<String> characters = StreamUtils.arrayToCharStream(arrayOfWords);
        characters.forEach(System.out::print);
    }
}