package ru.job4j.lsp.food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Expire {
    Food product;

    public Expire(Food product) {
        this.product = product;
    }

    public int checkExpiration(LocalDate now) {
        long period = ChronoUnit.DAYS.between(product.getCreateDate(), product.getExpireDate());
        long daysPassed = ChronoUnit.DAYS.between(product.getCreateDate(), now);
        return (int) (daysPassed * 100 / period);
    }
}
