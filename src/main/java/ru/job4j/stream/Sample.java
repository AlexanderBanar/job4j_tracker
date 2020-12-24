package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(-5);
        list.add(0);
        list.add(57);
        list.add(-79);
        list.add(4000);
        List<Integer> rsl = list.stream().filter(
                (x) -> x >= 0
        ).collect(Collectors.toList());
        System.out.println(rsl);
    }
}
