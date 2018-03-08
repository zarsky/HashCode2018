package main;

import java.util.List;

class Ride {

    long
            number,
            startX,
            startY,
            endX,
            endY,
            startStep,
            finishStep,
            distance;

    boolean isTaken = false;

    Ride(int num, int[] data) {
        number = num;
        startX = data[0];
        startY = data[1];
        endX = data[2];
        endY = data[3];
        startStep = data[4];
        finishStep = data[5];
        distance = Math.abs(startX - endX) + Math.abs(startY - endY);
    }

    Car chooseOptimalCar(List<Car> cars) {

        Car optimalCar = null;
        long
                diff = Long.MAX_VALUE,
                distToRide = Long.MIN_VALUE;

        for (Car car : cars) {
            if (car.getLastStepForRide(this) <= finishStep) {
                long
                        currDistToRide = car.getDistanceToRide(this),
                        currDiff = car.currentStep + currDistToRide - startStep;
                if (currDiff < diff) {
                    diff = currDiff;
                    optimalCar = car;
                } else if (currDiff == diff) {
                    if (currDistToRide > distToRide) {
                        distToRide = currDistToRide;
                        optimalCar = car;
                    }
                }
            }
        }

        return optimalCar;
    }
}
