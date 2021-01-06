package ru.job4j.lsp.food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    protected static List<Food> trash = new ArrayList<>();

    @Override
    public void add(Food product) {
        trash.add(product);
    }

    @Override
    public boolean accept(Food product, LocalDate now) {
        int percent = new Expire(product).checkExpiration(now);
        return percent >= 100;
    }

    public List<Food> clearProducts() {
        List<Food> rsl = new ArrayList<>(trash);
        trash.clear();
        return rsl;
    }
}
