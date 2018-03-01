import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] files = {"a_example", "b_should_be_easy", "c_no_hurry", "d_metropolis", "e_high_bonus"};

        String line;

        for (int fileNum = 0; fileNum < files.length; fileNum++) {

            List<Car> fleet = new ArrayList<>();
            List<Ride> rides = new ArrayList<>();

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

                for (int i = 0; i < f; i++) {
                    fleet.add(new Car());
                }

                for (int i = 0; i < n; i++) {
                    rides.add(new Ride(splitStringToNumbers(reader.readLine())));
                }

                for (int i = 0; i < n; i++) {
                    writer.write(rides.get(i).distance + "\n");
                }

                reader.close();
                writer.close();

                System.out.println(fileNum + " - done!");

            } catch (Exception e) {
                System.err.println(fileNum + " - error: " + e.getMessage());
            }
        }
    }

    static int[] splitStringToNumbers(String s) {
        String[] data = s.split(" ");
        int[] numbers = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }
        return numbers;
    }
}
