package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    protected static List<Food> warehouse = new ArrayList<>();

    @Override
    public void add(Food product) {
        warehouse.add(product);
    }
}
