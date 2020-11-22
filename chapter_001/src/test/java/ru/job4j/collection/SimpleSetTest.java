package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    private SimpleSet test = new SimpleSet();

    @Test
    public void whenAdd() {
        test.add(1);
        test.add(2);
        test.add(3);
        assertThat(test.get(0), is(1));
        assertThat(test.get(1), is(2));
        assertThat(test.get(2), is(3));
    }

    @Test
    public void whenAddUnique() {
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(2);
        assertThat(test.get(1), is(2));
    }

    @Test
    public void whenAddThenIt() {
        test.add(1);
        Iterator it = test.iterator();
        assertThat(it.next(), is(1));
    }
}