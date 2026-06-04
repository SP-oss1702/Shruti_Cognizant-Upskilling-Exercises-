import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks (0 - 100): ");
        int marks = sc.nextInt();

        String grade;

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks! Enter between 0 and 100.");
        } else if (marks >= 90) {
            grade = "A";
            System.out.println("Marks: " + marks + " → Grade: " + grade + " (Excellent!)");
        } else if (marks >= 80) {
            grade = "B";
            System.out.println("Marks: " + marks + " → Grade: " + grade + " (Very Good!)");
        } else if (marks >= 70) {
            grade = "C";
            System.out.println("Marks: " + marks + " → Grade: " + grade + " (Good!)");
        } else if (marks >= 60) {
            grade = "D";
            System.out.println("Marks: " + marks + " → Grade: " + grade + " (Pass!)");
        } else {
            grade = "F";
            System.out.println("Marks: " + marks + " → Grade: " + grade + " (Fail!)");
        }

        sc.close();
    }
}