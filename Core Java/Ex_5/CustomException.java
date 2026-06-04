import java.util.Scanner;

public class CustomException {

    // Custom Exception class
    static class InvalidAgeException extends Exception {
        InvalidAgeException(String message) {
            super(message);
        }
    }

    // Method that throws custom exception
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException(
                "Age " + age + " is invalid! Must be 18 or older."
            );
        } else {
            System.out.println("✅ Age " + age + " is valid. Access granted!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Custom Exception Example ===");
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("❌ InvalidAgeException caught!");
            System.out.println("Message: " + e.getMessage());
        } finally {
            System.out.println("Age check complete.");
        }

        sc.close();
    }
}