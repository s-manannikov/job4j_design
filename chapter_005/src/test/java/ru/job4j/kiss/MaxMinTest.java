package ru.job4j.kiss;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MaxMinTest {
    Comparator<Integer> comparator = Comparator.naturalOrder();
    MaxMin mm = new MaxMin();

    @Before
    public void setUp() {
        mm.value = List.of(3, 2, 1, 5, 4);
    }

    @Test
    public void whenMin() {
        assertThat(mm.min(comparator), is(1));
    }

    @Test
    public void whenMax() {
        assertThat(mm.max(comparator), is(5));
    }
}