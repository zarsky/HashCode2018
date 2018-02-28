import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input/example.in"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output/example.out"));
            while ((line = reader.readLine()) != null)
                writer.write(line);
            reader.close();
            writer.close();
            System.out.println("Done");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
