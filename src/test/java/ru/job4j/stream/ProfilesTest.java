package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenDeletingExtraAddress() {
        Address moscow = new Address("Moscow", "Lenina", 23, 103);
        Address kazan = new Address("Kazan", "G.Tukaya", 15, 7);
        Address ufa = new Address("Ufa", "Julaeva", 8, 56);
        Address moscowToDel = new Address("Moscow", "Lenina", 23, 103);
        List<Profile> profiles = List.of(
                new Profile(moscow),
                new Profile(kazan),
                new Profile(ufa),
                new Profile(moscowToDel)
        );
        List<Address> expected = List.of(
                kazan,
                moscow,
                ufa
        );
        List<Address> rsl = new Profiles().collect(profiles);
        assertThat(rsl, is(expected));
    }
}