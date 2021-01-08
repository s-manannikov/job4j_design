package ru.job4j.lsp.parking;

public interface Parking {

    Vehicle[] getCarPlaces();

    Vehicle[] getTruckPlaces();

    boolean park(Vehicle vehicle);

    void leave(Vehicle vehicle);
}
