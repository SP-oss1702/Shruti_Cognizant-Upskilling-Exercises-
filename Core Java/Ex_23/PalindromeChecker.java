import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Remove non-alphanumeric and convert to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Reverse the cleaned string
        String reversed = new StringBuilder(cleaned).reverse().toString();

        System.out.println("\n=== Palindrome Checker ===");
        System.out.println("Original : " + input);
        System.out.println("Cleaned  : " + cleaned);
        System.out.println("Reversed : " + reversed);

        if (cleaned.equals(reversed)) {
            System.out.println("Result   : ✅ YES it is a Palindrome!");
        } else {
            System.out.println("Result   : ❌ NO it is NOT a Palindrome!");
        }

        sc.close();
    }
}