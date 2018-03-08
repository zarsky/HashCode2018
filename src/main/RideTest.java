package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RideTest {

    Ride ride = new Ride(0, new int[]{0, 0, 3, 3, 5, 15});
    List<Car> cars = new ArrayList<>();

    @Before
    public void setUp() {

        cars.clear();

        Car car1 = new Car();
        car1.testNumber = 1;
        car1.currentX = 3;
        car1.currentY = 3;
        car1.currentStep = 5;
        cars.add(car1);

        Car car2 = new Car();
        car2.testNumber = 2;
        car2.currentX = 0;
        car2.currentY = 0;
        car2.currentStep = 10;
        cars.add(car2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void chooseOptimalCar() {
        assertEquals(1, ride.chooseOptimalCar(cars).testNumber);
    }
}