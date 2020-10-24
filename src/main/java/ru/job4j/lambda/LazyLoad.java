package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LazyLoad {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator for one-value array");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
        String[] names2 = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp2 = (left, right) -> {
            System.out.println("execute comparator for two-value array");
            return left.length() - right.length();
        };
        Arrays.sort(names2, lengthCmp2);
    }
}
