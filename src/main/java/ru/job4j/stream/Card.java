package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.suit + " " + this.value;
    }

    public static void main(String[] args) {
        Suit[] levels = Suit.values();
        Value[] tasks = Value.values();
        Stream.of(Suit.values())
                .flatMap(level -> Stream.of(Value.values())
                        .map(task -> new Card(level, task)))
                .forEach(System.out::println);
    }
}
