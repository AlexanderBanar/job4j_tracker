package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public static List<Integer> convert(Integer[][] subject) {
        return Arrays.stream(subject)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
