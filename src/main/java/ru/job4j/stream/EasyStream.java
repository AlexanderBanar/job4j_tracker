package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    public EasyStream(List<Integer> source) {
        this.source = source;
    }

    public List<Integer> getSource() {
        return source;
    }

    public static EasyStream of(List<Integer> source) {
        if (source.size() > 10) {
            throw new UnsupportedOperationException();
        }
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> temp = new ArrayList<>();
        for (var n : this.getSource()) {
            temp.add(fun.apply(n));
        }
        return new EasyStream(temp);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> temp = new ArrayList<>();
        for (var n : this.getSource()) {
            if (fun.test(n)) {
                temp.add(n);
            }
        }
        return new EasyStream(temp);
    }

    public List<Integer> collect() {
        return new ArrayList<>(this.getSource());
    }
}
