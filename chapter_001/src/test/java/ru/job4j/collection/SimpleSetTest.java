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
        Iterator it = test.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenAddUnique() {
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(2);
        Iterator it = test.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddThenIt() {
        test.add(1);
        Iterator it = test.iterator();
        assertThat(it.hasNext(), is(true));
    }
}