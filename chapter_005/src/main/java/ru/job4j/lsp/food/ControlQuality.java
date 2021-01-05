package ru.job4j.lsp.food;

import java.time.LocalDate;

public class ControlQuality {
    private final Storage warehouse;
    private final Storage shop;
    private final Storage trash;

    public ControlQuality(Storage warehouse, Storage shop, Storage trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public Storage chooseStorage(Food product, LocalDate now) {
        Storage storage = warehouse;
        int percent = new Expire(product).checkExpiration(now);
        if (percent > 25 && percent < 100) {
            new Discounter().checkDiscount(percent, product);
            storage = shop;
        } else if (percent >= 100) {
            storage = trash;
        }
        return storage;
    }
}