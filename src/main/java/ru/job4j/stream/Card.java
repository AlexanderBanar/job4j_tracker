package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream<Suit> stream = Stream.of(Suit.values());
        Stream<Value> stream2 = Stream.of(Value.values());
        List<Stream> common = Arrays.asList(stream, stream2);







    }
}
