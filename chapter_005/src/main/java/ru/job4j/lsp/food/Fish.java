package ru.job4j.lsp.food;

import java.time.LocalDate;

public class Fish extends Food {

    public Fish(String name, LocalDate expireDate, LocalDate createDate, double price) {
        super(name, expireDate, createDate, price);
    }
}
