package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    private SimpleArray<? super Object> test = new SimpleArray(new Object[3]);
    Iterator<? super Object> it = test.iterator();

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

    @Test
    public void whenHasNext() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenNext() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenNoSuchElement() throws NoSuchElementException {
        try {
            assertThat(it.next(), is(1));
            assertThat(it.next(), is(2));
            assertThat(it.next(), is(3));
            assertThat(it.next(), is(4));
        } catch (NoSuchElementException ex) {
        }
    }
}