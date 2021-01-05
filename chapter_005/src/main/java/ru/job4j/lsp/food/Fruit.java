package ru.job4j.lsp.food;

import java.time.LocalDate;

public class Fruit extends Food {

    public Fruit(String name, LocalDate expireDate, LocalDate createDate, double price) {
        super(name, expireDate, createDate, price);
    }
}
