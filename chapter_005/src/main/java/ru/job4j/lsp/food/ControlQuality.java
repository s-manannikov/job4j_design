package ru.job4j.lsp.food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Storage> stores = new ArrayList<>();

    public ControlQuality(Storage warehouse, Storage shop, Storage trash) {
        this.stores.add(warehouse);
        this.stores.add(shop);
        this.stores.add(trash);
    }

    public void chooseStorage(Food product, LocalDate now) {
        for (Storage store : stores) {
            if (store.accept(product, now)) {
                store.add(product);
                break;
            }
        }
    }

    public void resort(LocalDate now) {
        List<Food> allProducts = new ArrayList<>();
        for (Storage store : stores) {
            allProducts.addAll(store.clearProducts());
        }
        allProducts.forEach(i -> chooseStorage(i, now));
    }
}