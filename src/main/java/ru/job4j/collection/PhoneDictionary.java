package ru.job4j.collection;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> namePred = (x) -> x.getName().contains(key);
        Predicate<Person> surnamePred = (x) -> x.getSurname().contains(key);
        Predicate<Person> addressPred = (x) -> x.getAddress().contains(key);
        Predicate<Person> phonePred = (x) -> x.getPhone().contains(key);
        Predicate<Person> combine = namePred.or(surnamePred).or(addressPred).or(phonePred);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}

