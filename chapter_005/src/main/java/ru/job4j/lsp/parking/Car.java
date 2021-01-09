package ru.job4j.lsp.parking;

public class Car implements Vehicle {
    private final String model;
    private final String id;
    private static final String TYPE = "car";
    private static final int SIZE = 1;

    public Car(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public String toString() {
        return "Car{" + "id='" + id + '\'' + '}';
    }
}
