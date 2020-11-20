package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
            mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int i = indexOf(id);
        if (i == -1) {
            return false;
        }
        mem.set(i, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int i = indexOf(id);
        if (i == -1) {
            return false;
        }
        mem.remove(i);
        return true;
    }

    @Override
    public T findById(String id) {
        int i = indexOf(id);
        return i != -1 ? mem.get(i) : null;
    }

    private int indexOf(String id) {
        return IntStream.range(0, mem.size()).filter(i -> mem.get(i).getId().equals(id)).findFirst().orElse(-1);
    }
}