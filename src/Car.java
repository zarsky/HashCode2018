import java.util.ArrayList;
import java.util.List;

public class Car {

    long
            currentX = 0,
            currentY = 0,
            currentStep = 0;

    int pos = -1;

    List<Ride> availableRides;
    List<Long> rideNumbers = new ArrayList<>();

    Car(List<Ride> rides) {
        availableRides = rides;
    }

    void takeTheBestRide() {
        long minStep = Long.MAX_VALUE;
        pos = -1;
        for (int i = 0; i < availableRides.size(); i++) {
            Ride currentRide = availableRides.get(i);
            long currentLastStep = getLastStepForRide(currentRide);
            if (currentLastStep <= currentRide.finishStep && currentLastStep < minStep) {
                minStep = currentLastStep;
                pos = i;
            }
        }
        if (pos > -1) {
            takeRide(availableRides.get(pos));
            availableRides.remove(pos);
        }
    }

    void takeRidesWhileCan() {
        do {
            takeTheBestRide();
        } while (pos > -1);
    }

    void takeRide(Ride ride) {
        currentX = ride.endX;
        currentY = ride.endY;
        currentStep = Math.max(getDistanceToRide(ride), ride.startStep) + ride.distance;
        rideNumbers.add(ride.number);
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
