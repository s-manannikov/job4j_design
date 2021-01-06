package ru.job4j.lsp.food;

import java.time.LocalDate;
import java.util.List;

public interface Storage {

    void add(Food product);

    boolean accept(Food product, LocalDate now);

    List<Food> clearProducts();
}