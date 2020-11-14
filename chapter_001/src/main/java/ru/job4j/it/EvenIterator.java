package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    private int[] even() {
        return Arrays.stream(data).filter(i -> i % 2 == 0).toArray();
    }

    @Override
    public boolean hasNext() {
        return point < even().length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return even()[point++];
    }
}
