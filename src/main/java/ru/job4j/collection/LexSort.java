package ru.job4j.collection;

import java.util.Comparator;
import java.util.regex.Pattern;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftByDot = left.split(Pattern.quote("."));
        String[] rightByDot = right.split(Pattern.quote("."));
        int leftToInt = Integer.parseInt(leftByDot[0]);
        int rightToInt = Integer.parseInt(rightByDot[0]);
        return Integer.compare(leftToInt, rightToInt);
    }
}
