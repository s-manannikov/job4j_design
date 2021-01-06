package ru.job4j.lsp.food;

import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class ControlQualityTest {
    Food f1 = new Meat(
            "some meat",
            LocalDate.of(2020, 12, 25),
            LocalDate.of(2021, 1, 6),
            400
    );
    Food f2 = new Fish(
            "some fish",
            LocalDate.of(2021, 1, 4),
            LocalDate.of(2021, 1, 23),
            500
    );
    Food f3 = new Milk(
            "some milk",
            LocalDate.of(2020, 12, 25),
            LocalDate.of(2021, 1, 3),
            80
    );
    Food f4 = new Bread(
            "some bread",
            LocalDate.of(2020, 12, 29),
            LocalDate.of(2021, 1, 7),
            50
    );
    Food f5 = new Fruit(
            "some fruit",
            LocalDate.of(2020, 12, 20),
            LocalDate.of(2021, 1, 20),
            100
    );

    @Test
    public void whenAddToStoragesThenCheck() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        LocalDate date = LocalDate.of(2021, 1, 5);
        ControlQuality cq = new ControlQuality(warehouse, shop, trash);
        cq.chooseStorage(f1, date);
        cq.chooseStorage(f2, date);
        cq.chooseStorage(f3, date);
        cq.chooseStorage(f4, date);
        cq.chooseStorage(f5, date);
        assertTrue(Shop.shop.contains(f1));
        assertTrue(Warehouse.warehouse.contains(f2));
        assertTrue(Trash.trash.contains(f3));
        assertTrue(Shop.shop.contains(f4));
        assertTrue(Shop.shop.contains(f5));
    }

    @Test
    public void whenAddToStoragesThenResort() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        LocalDate date = LocalDate.of(2021, 1, 5);
        ControlQuality cq = new ControlQuality(warehouse, shop, trash);
        cq.chooseStorage(f1, date);
        cq.chooseStorage(f2, date);
        cq.chooseStorage(f3, date);
        cq.chooseStorage(f4, date);
        cq.chooseStorage(f5, date);
        LocalDate newDate = LocalDate.of(2021, 1, 15);
        cq.resort(newDate);
        assertTrue(Trash.trash.contains(f1));
        assertTrue(Shop.shop.contains(f2));
        assertTrue(Trash.trash.contains(f3));
        assertTrue(Trash.trash.contains(f4));
        assertTrue(Shop.shop.contains(f5));
    }
}