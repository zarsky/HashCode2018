import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        String[] files = {"big", "example", "medium", "small"};

        String line;

        for (int i = 0; i < files.length; i++) {

            try {
                BufferedReader reader = new BufferedReader(new FileReader("input/" + files[i] + ".in"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("output/" + files[i] + ".out"));
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
