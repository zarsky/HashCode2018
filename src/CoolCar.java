import java.util.List;

public class CoolCar extends Car {

    CoolCar(List<Ride> rides) {
        super(rides);
    }

    void takeTheBestRide() {
        takeRide(availableRides.get(0)); // TODO Logic here
    }
}
