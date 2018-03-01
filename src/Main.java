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

        for (int i = 0; i < files.length; i++) {

            List<Car> fleet = new ArrayList<>();

            try {
                BufferedReader reader = new BufferedReader(new FileReader("input/" + files[i] + ".in"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("output/" + files[i] + ".out"));

                String inputs = reader.readLine();

                while ((line = reader.readLine()) != null)
                    writer.write(line);

                reader.close();
                writer.close();
                System.out.println(i + " - done!");
            } catch (Exception e) {
                System.err.println(i + " - error: " + e.getMessage());
            }
        }
    }
}
