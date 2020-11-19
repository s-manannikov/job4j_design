package ru.job4j.generics;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MemStoreTest {
    private MemStore memStore = new MemStore();

    @Test
    public void whenAdd() {
        Role expected = new Role("666", "Role6");
        memStore.add(expected);
        assertThat(memStore.findById("666"), is(expected));
    }

    @Test
    public void whenReplace() {
        User user = new User("777", "Name7");
        memStore.replace("111", user);
        try {
            memStore.findById("111");
        } catch (IndexOutOfBoundsException ex) {
        }
    }

    @Test
    public void whenDelete() {
        User user = new User("111", "Name1");
        memStore.add(user);
        memStore.delete("111");
        try {
            memStore.findById("111");
        } catch (IndexOutOfBoundsException ex) {
        }
    }

    @Test
    public void whenFindById() {
        Role role = new Role("222", "Role2");
        memStore.add(role);
        assertThat(memStore.findById("222"), is(role));
    }
}