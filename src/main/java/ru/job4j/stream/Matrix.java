package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public static List<Integer> convert(Integer[][] subject) {
        List<List<Integer>> tempLarge = new ArrayList<>();
        List<Integer> tempSmall = new ArrayList<>();
        for (Integer[] i : subject) {
            tempSmall.addAll(Arrays.asList(i));
            tempLarge.add(tempSmall);
            tempSmall.clear();
        }
        return tempLarge.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
