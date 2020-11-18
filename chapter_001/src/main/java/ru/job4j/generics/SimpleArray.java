package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] data;
    private int count = 0;

    public SimpleArray(Object[] data) {
        this.data = data;
    }

    public void add(T model) {
        data[count++] = model;
    }

    private void checkIndex(int index) {
        if (Objects.checkIndex(index, count) != index) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void set(int index, T model) {
        checkIndex(index);
        data[index] = model;
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(data, index + 1, data, index, count - index - 1);
        data[data.length - 1] = null;
        count--;
    }

    public T get(int index) {
        checkIndex(index);
            return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[point++];
            }
        };
    }
}
