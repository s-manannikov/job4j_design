package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 1, 2);
        assertThat(Arrays.asList(1, 3, 2), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 9, 5, 7, 3));
        Predicate<Integer> predicate = x -> x > 5;
        ListUtils.removeIf(input, predicate);
        assertThat(Arrays.asList(1, 5, 3), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 9, 5, 7, 3));
        Predicate<Integer> predicate = x -> x > 5;
        ListUtils.replaceIf(input, predicate, 99);
        assertThat(Arrays.asList(1, 99, 5, 99, 3), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 9, 5, 7, 4, 2, 8));
        List<Integer> elements = new ArrayList<>(Arrays.asList(2, 5, 4));
        ListUtils.removeAll(input, elements);
        assertThat(Arrays.asList(1, 3, 9, 7, 8), Is.is(input));
    }
}