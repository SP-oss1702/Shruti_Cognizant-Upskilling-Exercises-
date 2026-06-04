import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();

        System.out.println("=== ArrayList - Student Names ===");
        System.out.print("How many students to add? ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter student " + i + " name: ");
            String name = sc.nextLine();
            students.add(name);
        }

        System.out.println("\n=== All Students ===");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }

        System.out.println("\nTotal students: " + students.size());
        sc.close();
    }
}