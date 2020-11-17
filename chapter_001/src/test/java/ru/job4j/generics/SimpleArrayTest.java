package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    private SimpleArray<? super Object> test = new SimpleArray(new Object[3]);

    @Before
    public void setUp() {
        test.add(1);
        test.add(2);
        test.add(3);
    }

    @Test
    public void whenAdd() {
        assertThat(test.get(0), is(1));
        assertThat(test.get(1), is(2));
        assertThat(test.get(2), is(3));
    }

    @Test
    public void whenSet() {
        test.set(1, 4);
        assertThat(test.get(1), is(4));
    }

    @Test
    public void whenRemove() {
        test.remove(1);
        assertThat(test.get(1), is(3));
    }

    @Test
    public void whenGet() {
        assertThat(test.get(0), is(1));
        assertThat(test.get(1), is(2));
        assertThat(test.get(2), is(3));
    }

    @Test
    public void whenOutOfBounds() throws IndexOutOfBoundsException {
        try {
            test.get(3);
        } catch (IndexOutOfBoundsException ex) {
        }
    }
}