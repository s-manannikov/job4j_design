package ru.job4j.lsp.parking;

import java.util.stream.IntStream;

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
        boolean rsl = false;
        if (vehicle.getSize() == 1) {
            rsl = isParked(vehicle, carPlaces);
        }
        if (vehicle.getSize() > 1) {
            if (isParked(vehicle, truckPlaces)) {
                rsl = true;
            } else {
                int i = findFreePlaceBySize(vehicle.getSize());
                if (i != -1) {
                    for (int j = 0; j < vehicle.getSize(); j++) {
                        carPlaces[i + j] = vehicle;
                    }
                    rsl = true;
                }
            }
        }
        return rsl;
    }

    @Override
    public void leave(Vehicle vehicle) {
        if (vehicle.getSize() == 1 && !isLeft(vehicle, carPlaces)) {
            System.out.println("Car not found!");
        }
        if (vehicle.getSize() > 1 && !isLeft(vehicle, truckPlaces) && !isLeft(vehicle, carPlaces)) {
            System.out.println("Truck not found!");
        }
    }

    private boolean isLeft(Vehicle vehicle, Vehicle[] vehicles) {
        boolean rsl = false;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicle.equals(vehicles[i])) {
                vehicles[i] = null;
                rsl = true;
            }
        }
        return rsl;
    }

    private boolean isParked(Vehicle vehicle, Vehicle[] places) {
        boolean rsl = false;
        int i = findFreePlace(places);
        if (i != -1) {
            places[i] = vehicle;
            rsl = true;
        }
        return rsl;
    }

    private int findFreePlace(Vehicle[] places) {
        return IntStream.range(0, places.length).filter(i -> places[i] == null).findFirst().orElse(-1);
    }

    private int findFreePlaceBySize(int size) {
        int rsl = -1, counter = 0, foundPlaces = 0;
        for (int i = 0; i <= carPlaces.length - size; i++) {
            while (counter < size) {
                if (carPlaces[i + counter] == null) {
                    foundPlaces++;
                }
                counter++;
            }
            if (counter == foundPlaces) {
                rsl = i;
                break;
            } else {
                counter = 0;
                foundPlaces = 0;
            }
        }
        return rsl;
    }
}