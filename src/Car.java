import java.util.ArrayList;
import java.util.List;

public class Car {

    long
            currentX = 0,
            currentY = 0,
            currentStep = 0;

    List<Long> rides = new ArrayList<>();

    void takeTheBestRide(List<Ride> rides) {
        takeRide(rides.get(0));
    }

    void takeRide(Ride ride) {
        currentX = ride.endX;
        currentY = ride.endY;
        currentStep = Math.max(getDistanceToRide(ride), ride.startStep) + ride.distance;
        rides.add(ride.number);
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
        Car newCar = new Car();
        newCar.currentX = currentX;
        newCar.currentY = currentY;
        newCar.currentStep = currentStep;
        return newCar;
    }
}
