import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    public static void main(String[] args) {
        System.out.println("=== File Reading Example ===");
        System.out.println("Reading from output.txt:\n");

        try {
            BufferedReader reader = new BufferedReader(
                new FileReader("output.txt")
            );

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }

            reader.close();
            System.out.println("\n✅ File read successfully!");

        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
            System.out.println("Make sure output.txt exists!");
            System.out.println("Run Exercise 22 first to create the file.");
        }
    }
}