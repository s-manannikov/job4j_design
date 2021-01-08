package ru.job4j.lsp.parking;

public class NewParking implements Parking {
    private final Vehicle[] carPlaces;
    private final Vehicle[] truckPlaces;

    public NewParking(int carPlaces, int truckPlaces) {
        this.carPlaces = new Vehicle[carPlaces];
        this.truckPlaces = new Vehicle[truckPlaces];
    }

    @Override
    public Vehicle[] getCarPlaces() {
        return carPlaces;
    }

    @Override
    public Vehicle[] getTruckPlaces() {
        return truckPlaces;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }

    @Override
    public void leave(Vehicle vehicle) {
    }
}
