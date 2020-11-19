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
        if (indexOf(id) == -1) {
            return false;
        }
        mem.set(indexOf(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        if (indexOf(id) == -1) {
            return false;
        }
        mem.remove(indexOf(id));
        return true;
    }

    @Override
    public T findById(String id) {
        return mem.get(indexOf(id));
    }

    private int indexOf(String id) {
        return IntStream.range(0, mem.size()).filter(i -> mem.get(i).getId().equals(id)).findFirst().orElse(-1);
    }
}