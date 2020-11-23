package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int count = 0;

    public T poll() {
        T rsl = null;
        int i = 0, j = 1;
        if (count == 0) {
            throw new NoSuchElementException();
        }
        while (i <= count && j > 0) {
            if (i == count) {
            in.push(out.pop());
            j--;
            } else {
                rsl = in.pop();
                out.push(rsl);
                j = ++i;
            }
        }
        count--;
        return rsl;
    }

    public void push(T value) {
        in.push(value);
        count++;
    }
}