package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Function {
    public List<Double> diapason(int start, int end, UnaryOperator<Double> func) {
        List<Double> values = new ArrayList<>();
        double rsl;
        for (int i = start; i < end; i++) {
            rsl = func.apply((double) i);
            values.add(rsl);
        }
        return values;
    }
}
