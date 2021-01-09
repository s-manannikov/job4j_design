package ru.job4j.lsp.parking;

public class Truck implements Vehicle {
    private final String model;
    private final String id;
    private static final String TYPE = "truck";
    private final int size;

    public Truck(String model, String id, int size) {
        this.model = model;
        this.id = id;
        this.size = size;
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
        return size;
    }

    @Override
    public String toString() {
        return "Truck{" + "id='" + id + '\'' + '}';
    }
}
