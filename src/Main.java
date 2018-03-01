import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final String SPACE = " ";

    public static void main(String[] args) {

        String[] files = {"a_example", "b_should_be_easy", "c_no_hurry", "d_metropolis", "e_high_bonus"};

        String line;

        for (int fileNum = 0; fileNum < files.length; fileNum++) {

            try {

                BufferedReader reader = new BufferedReader(new FileReader("input/" + files[fileNum] + ".in"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("output/" + files[fileNum] + ".out"));

                int[] inputs = splitStringToNumbers(reader.readLine());

                int
                        r = inputs[0],
                        c = inputs[1],
                        f = inputs[2],
                        n = inputs[3],
                        b = inputs[4],
                        t = inputs[5];

                List<Car> fleet = new ArrayList<>(f);
                List<Ride> rides = new ArrayList<>(n);

                for (int i = 0; i < n; i++) {
                    rides.add(new Ride(i, splitStringToNumbers(reader.readLine())));
                }

                for (int i = 0; i < f; i++) {
                    fleet.add(new Car(rides));
                }

                // TODO solution goes here
                while (rides.size() > 0) {
                    for (int i = 0; i < fleet.size(); i++) {
                        if (rides.size() > 0)
                            fleet.get(i).takeTheBestRide();
                    }
                }

                // Output
                for (int i = 0; i < fleet.size(); i++) {
                    Car currentCar = fleet.get(i);
                    StringBuilder sb = new StringBuilder();
                    int numRides = currentCar.rideNumbers.size();
                    sb.append(numRides).append(SPACE);
                    for (int j = 0; j < numRides; j++) {
                        sb.append(currentCar.rideNumbers.get(j)).append(SPACE);
                    }
                    sb.append("\n");
                    writer.write(sb.toString());
                }

                reader.close();
                writer.close();

                System.out.println(fileNum + " - done!");

            } catch (IOException e) {
                System.err.println(fileNum + " - error: " + e.getMessage());
            }
        }
    }

    static int[] splitStringToNumbers(String s) {
        String[] data = s.split(SPACE);
        int[] numbers = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }
        return numbers;
    }
}
