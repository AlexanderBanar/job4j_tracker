package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        Predicate<Attachment> tester = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        rsl = filter(rsl, tester);
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        Predicate<Attachment> tester = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        rsl = filter(rsl, tester);
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> tester) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (tester.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
