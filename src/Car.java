import java.util.ArrayList;
import java.util.List;

public class Car {

    long
            currentX = 0,
            currentY = 0,
            currentStep = 0;

    List<Ride> availableRides;
    List<Long> rideNumbers = new ArrayList<>();

    Car(List<Ride> rides) {
        availableRides = rides;
    }

    void takeTheBestRide() {
        takeRide(availableRides.get(0));
    }

    void takeRide(Ride ride) {
        currentX = ride.endX;
        currentY = ride.endY;
        currentStep = Math.max(getDistanceToRide(ride), ride.startStep) + ride.distance;
        rideNumbers.add(ride.number);
        availableRides.remove(ride);
    }

    long getLastStepForRide(Ride ride) {
        Car cloneCar = this.clone();
        cloneCar.takeRide(ride);
        return cloneCar.currentStep;
    }

    long getDistanceToRide(Ride ride) {
        return Math.abs(currentX - ride.startX) + Math.abs(currentY - ride.startY);
    }

    @Override
    protected Car clone() {
        Car newCar = new Car(availableRides);
        newCar.currentX = currentX;
        newCar.currentY = currentY;
        newCar.currentStep = currentStep;
        return newCar;
    }
}
