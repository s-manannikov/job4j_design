package ru.job4j.lsp.parking;

public class NewParking implements Parking {
    private final int carPlaces;
    private final int truckPlaces;

    public NewParking(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
    }

    @Override
    public void park(Vehicle vehicle) {
    }

    @Override
    public void leave(Vehicle vehicle) {
    }
}
