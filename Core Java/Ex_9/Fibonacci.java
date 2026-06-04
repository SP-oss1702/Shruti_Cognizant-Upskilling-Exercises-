import java.util.Scanner;

public class Fibonacci {

    // Recursive method
    static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Please enter a positive integer!");
        } else {
            System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));

            System.out.println("\nFibonacci Series up to " + n + ":");
            for (int i = 0; i <= n; i++) {
                System.out.print(fibonacci(i));
                if (i < n) System.out.print(" → ");
            }
        }

        sc.close();
    }
}