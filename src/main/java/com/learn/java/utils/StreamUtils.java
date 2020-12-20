package com.learn.java.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class StreamUtils {
    /* convert list of words to char stream */
    public static List<String> arrayToCharStream(String[] arrayOfWords) {
        List<String> words = Arrays.asList(arrayOfWords);
        return words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
