import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();

        System.out.println("=== HashMap - Student ID to Name ===");
        System.out.print("How many students to add? ");
        int count = sc.nextInt();
        sc.nextLine();

        // Add entries
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter student ID   : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter student name : ");
            String name = sc.nextLine();
            students.put(id, name);
        }

        // Display all
        System.out.println("\n=== All Students ===");
        for (HashMap.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("ID: " + entry.getKey() +
                             " → Name: " + entry.getValue());
        }

        // Search by ID
        System.out.print("\nEnter ID to search: ");
        int searchId = sc.nextInt();

        if (students.containsKey(searchId)) {
            System.out.println("✅ Found: " + students.get(searchId));
        } else {
            System.out.println("❌ No student found with ID: " + searchId);
        }

        sc.close();
    }
}