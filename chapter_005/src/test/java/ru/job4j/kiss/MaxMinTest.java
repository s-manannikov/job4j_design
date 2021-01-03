package ru.job4j.kiss;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {
    Comparator<Integer> comparator = Comparator.naturalOrder();
    MaxMin mm = new MaxMin();

    @Before
    public void setUp() {
        mm.value = List.of(3, 2, 1, 5, 4);
    }

    @Test
    public void whenMin() {
        assertEquals(mm.min(comparator), 1);
    }

    @Test
    public void whenMax() {
        assertEquals(mm.max(comparator), 5);
    }
}