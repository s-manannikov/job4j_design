package ru.job4j.lsp.food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    protected static List<Food> shop = new ArrayList<>();

    @Override
    public void add(Food productToShop) {
        shop.add(productToShop);
    }

    @Override
    public boolean accept(Food product, LocalDate now) {
        int percent = new Expire(product).checkExpiration(now);
        if (percent >= 25 && percent <= 75) {
            return true;
        } else if (percent > 75 && percent < 100) {
            new Discounter().checkDiscount(product);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Food> clearProducts() {
        List<Food> rsl = new ArrayList<>(shop);
        shop.clear();
        return rsl;
    }
}
