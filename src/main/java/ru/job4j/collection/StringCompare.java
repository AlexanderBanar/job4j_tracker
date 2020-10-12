package ru.job4j.collection;

import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        char[] leftCharAr = left.toCharArray();
        char[] rightCharAr = right.toCharArray();
        int maxSize = Math.max(leftCharAr.length, rightCharAr.length);
        int equalLengths = leftCharAr.length - rightCharAr.length;
        for (int i = 0; i < maxSize; i++) {
            if (leftCharAr.length > i && rightCharAr.length > i) {
                rsl = Character.compare(leftCharAr[i], rightCharAr[i]);
            }
            if (rsl != 0) {
                break;
            }
            if (i == maxSize - 2 && equalLengths != 0) {
                rsl = (leftCharAr.length < rightCharAr.length) ? Character.compare(' ', rightCharAr[i+1]) : Character.compare(' ', leftCharAr[i+1]);
            }
        }
        return rsl;
    }
}
