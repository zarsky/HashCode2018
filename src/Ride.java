public class Ride {

    long
            startX,
            startY,
            endX,
            endY,
            start,
            finish,
            distance;

    Ride(int startX, int startY, int endX, int endY, int start, int finish) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.start = start;
        this.finish = finish;
        distance = Math.abs(this.startX - this.endX) + Math.abs(this.startY - this.endY);
    }
}
