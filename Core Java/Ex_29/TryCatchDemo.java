import java.util.Scanner;

public class TryCatchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Try-Catch Division Example ===");

        try {
            System.out.print("Enter first number  : ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number : ");
            int num2 = sc.nextInt();

            int result = num1 / num2;
            System.out.println("Result : " + num1 + " / " + num2 + " = " + result);

        } catch (ArithmeticException e) {
            System.out.println("❌ Error: Cannot divide by zero!");
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please enter integers only.");
        } finally {
            System.out.println("Program execution complete.");
        }

        sc.close();
    }
}