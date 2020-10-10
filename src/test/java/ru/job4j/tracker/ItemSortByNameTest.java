package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemSortByNameTest {
    @Test
    public void whenAscendingSort() {
        Item first = new Item();
        first.setId(1);
        Item second = new Item();
        second.setId(2);
        Item third = new Item();
        third.setId(3);
        List<Item> items = Arrays.asList(third, first, second);
        List<Item> expected = Arrays.asList(first, second, third);
        Collections.sort(items);
        assertThat(items, is(expected));
    }

    @Test
    public void whenDescendingSort() {
        Item first = new Item();
        first.setId(1);
        Item second = new Item();
        second.setId(2);
        Item third = new Item();
        third.setId(3);
        List<Item> items = Arrays.asList(first, second, third);
        List<Item> expected = Arrays.asList(third, second, first);
        Collections.sort(items, new ItemReverseSort());
        assertThat(items, is(expected));
    }

    @Test
    public void whenSortByName() {
        Item first = new Item();
        first.setName("abcde");
        Item second = new Item();
        second.setName("cdbea");
        Item third = new Item();
        third.setName("edcba");
        List<Item> items = Arrays.asList(third, second, first);
        List<Item> expected = Arrays.asList(first, second, third);
        Collections.sort(items, new ItemSortByName());
        assertThat(items, is(expected));
    }
}