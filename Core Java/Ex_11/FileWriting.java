import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== File Writing Example ===");
        System.out.print("Enter text to write to file: ");
        String text = sc.nextLine();

        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("=== File Writing Example ===\n");
            writer.write("Content: " + text + "\n");
            writer.write("Written successfully!");
            writer.close();

            System.out.println("✅ Data written to output.txt successfully!");

        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }

        sc.close();
    }
}