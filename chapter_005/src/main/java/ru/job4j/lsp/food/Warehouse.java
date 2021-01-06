package ru.job4j.lsp.food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    protected static List<Food> warehouse = new ArrayList<>();

    @Override
    public void add(Food product) {
        warehouse.add(product);
    }

    @Override
    public boolean accept(Food product, LocalDate now) {
        int percent = new Expire(product).checkExpiration(now);
        return percent < 25;
    }
}
