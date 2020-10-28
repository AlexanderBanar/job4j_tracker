package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> temp = profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
        Comparator<Address> citySort = (x, y) -> x.getCity().compareTo(y.getCity());
        temp.sort(citySort);
        List<Address> rsl = temp.stream()
                .distinct()
                .collect(Collectors.toList());
        return rsl;
    }
}
