public class Ride {

    long
            startX,
            startY,
            endX,
            endY,
            startStep,
            finishStep,
            distance;

    Ride(int[] data) {
        startX = data[0];
        startY = data[1];
        endX = data[2];
        endY = data[3];
        startStep = data[4];
        finishStep = data[5];
        distance = Math.abs(startX - endX) + Math.abs(startY - endY);
    }
}
