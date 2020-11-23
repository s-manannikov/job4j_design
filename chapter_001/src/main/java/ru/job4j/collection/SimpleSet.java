package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> data = new SimpleArray<>();

    public void add(E model) {
        if (!data.contains(model)) {
            data.add(model);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }
}
