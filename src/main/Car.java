package main;

import java.util.ArrayList;
import java.util.List;

class Car {

    long
            currentX,
            currentY,
            currentStep,
            testNumber;

    List<Long> rideNumbers = new ArrayList<>();
    List<Ride> availableRides = new ArrayList<>();

    Ride takeTheBestRide() {
        long minWaste = Long.MAX_VALUE;
        int pos = -1;
        for (int i = 0; i < availableRides.size(); i++) {
            Ride currentRide = availableRides.get(i);
            long currentLastStep = getLastStepForRide(currentRide);
            if (currentLastStep <= currentRide.finishStep) {
                long currentWaste = currentLastStep - currentRide.distance;
                if (currentWaste < minWaste) {
                    minWaste = currentWaste;
                    pos = i;
                }
            }
        }
        if (pos > -1) {
            Ride ride = availableRides.get(pos);
            takeRide(ride);
            availableRides.clear();
            return ride;
        }
        return null;
    }

    void takeRide(Ride ride) {
        currentStep = getLastStepForRide(ride);
        currentX = ride.endX;
        currentY = ride.endY;
        rideNumbers.add(ride.number);
        ride.isTaken = true;
    }

    long getLastStepForRide(Ride ride) {
        return Math.max(currentStep + getDistanceToRide(ride), ride.startStep) + ride.distance;
    }

    long getDistanceToRide(Ride ride) {
        return Math.abs(currentX - ride.startX) + Math.abs(currentY - ride.startY);
    }
}
