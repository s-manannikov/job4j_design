package ru.job4j.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewParkingTest {
    Vehicle car1 = new Car("car1", "C001");
    Vehicle truck1 = new Truck("truck1", "T001", 2);
    Vehicle car2 = new Car("car2", "C002");
    Vehicle truck2 = new Truck("truck2", "T002", 2);

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
        parking.park(truck1);
        assertEquals(parking.getCarPlaces()[0], truck1);
        assertEquals(parking.getCarPlaces()[1], truck1);
    }

    @Test
    public void whenNoPlaceForTruck() {
        Parking parking = new NewParking(3, 0);
        parking.park(car1);
        parking.park(car2);
        assertFalse(parking.park(truck1));
    }

    @Test
    public void whenDifferentSizes() {
        Parking parking = new NewParking(8, 0);
        Vehicle truck3 = new Truck("truck3", "T003", 3);
        Vehicle truck4 = new Truck("truck4", "T004", 4);
        Vehicle truck5 = new Truck("truck5", "T005", 2);
        assertTrue(parking.park(truck3));
        assertTrue(parking.park(truck4));
        assertFalse(parking.park(truck5));
    }

    @Test
    public void whenFalseThenTrue() {
        Parking parking = new NewParking(2, 0);
        parking.park(truck1);
        assertFalse(parking.park(truck2));
        parking.leave(truck1);
        assertTrue(parking.park(truck2));
    }
}