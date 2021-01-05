package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    protected static List<Food> trash = new ArrayList<>();

    @Override
    public void add(Food product) {
        trash.add(product);
    }
}
