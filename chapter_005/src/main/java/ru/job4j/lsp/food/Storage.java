package ru.job4j.lsp.food;

import java.time.LocalDate;

public interface Storage {

    void add(Food product);

    boolean accept(Food product, LocalDate now);
}
