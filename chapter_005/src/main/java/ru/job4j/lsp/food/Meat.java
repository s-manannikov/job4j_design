package ru.job4j.lsp.food;

import java.time.LocalDate;

public class Meat extends Food {

    public Meat(String name, LocalDate expireDate, LocalDate createDate, double price) {
        super(name, expireDate, createDate, price);
    }
}
