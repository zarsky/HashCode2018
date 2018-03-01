public class Ride {

    long
            startX,
            startY,
            endX,
            endY,
            startStep,
            finishStep,
            distance;

    Ride(int startX, int startY, int endX, int endY, int startStep, int finishStep) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.startStep = startStep;
        this.finishStep = finishStep;
        distance = Math.abs(this.startX - this.endX) + Math.abs(this.startY - this.endY);
    }
}
