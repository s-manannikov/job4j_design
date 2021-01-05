package ru.job4j.lsp.food;

import java.time.LocalDate;

public class Milk extends Food {

    public Milk(String name, LocalDate expireDate, LocalDate createDate, double price) {
        super(name, expireDate, createDate, price);
    }
}
