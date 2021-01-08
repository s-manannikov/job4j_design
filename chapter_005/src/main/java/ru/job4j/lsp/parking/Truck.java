package ru.job4j.lsp.parking;

public class Truck implements Vehicle {
    private final String model;
    private static final String TYPE = "truck";
    private static final int SIZE = 2;

    public Truck(String model) {
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
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
        return "Truck{" + "model='" + model + '\'' + '}';
    }
}
