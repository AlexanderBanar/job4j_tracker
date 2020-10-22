package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> list) {
        Predicate<Attachment> test1 = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        Predicate<Attachment> test2 = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (test1.test(att) || test2.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
