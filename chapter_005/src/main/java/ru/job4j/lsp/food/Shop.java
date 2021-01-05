package ru.job4j.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    protected static List<Food> shop = new ArrayList<>();

    @Override
    public void add(Food productToShop) {
        shop.add(productToShop);
    }
}
