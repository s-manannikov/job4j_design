package ru.job4j.lsp.parking;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NewParkingTest {
    Vehicle car1 = new Car("car1");
    Vehicle truck1 = new Truck("truck1");
    Vehicle car2 = new Car("car2");
    Vehicle truck2 = new Truck("truck2");
/*
    @Test
    public void whenParkOnFreePlace() {
        Parking parking = new NewParking(1, 1);
        assertTrue(parking.park(car1));
        assertTrue(parking.park(truck1));
    }

    @Test
    public void whenParkingHasNoFreePlace() {
        Parking parking = new NewParking(1, 1);
        parking.park(car1);
        parking.park(truck1);
        assertFalse(parking.park(car2));
        assertFalse(parking.park(truck2));
    }

    @Test
    public void whenLeaveParking() {
        Parking parking = new NewParking(1, 1);
        parking.park(car1);
        parking.park(truck1);
        parking.leave(car1);
        parking.leave(truck1);
        assertNull(parking.getCarPlaces()[0]);
        assertNull(parking.getTruckPlaces()[0]);
    }

    @Test
    public void whenTruckOnPlaceForCars() {
        Parking parking = new NewParking(2, 0);
        assertTrue(parking.park(truck1));
    }

    @Test
    public void whenNoPlaceForTruck() {
        Parking parking = new NewParking(3, 0);
        parking.park(car1);
        parking.park(car2);
        assertFalse(parking.park(truck1));
    }
 */
}