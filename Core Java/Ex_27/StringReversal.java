import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Method 1: Using StringBuilder
        String reversed = new StringBuilder(input).reverse().toString();

        // Method 2: Using loop
        String reversedLoop = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversedLoop += input.charAt(i);
        }

        System.out.println("\n=== String Reversal ===");
        System.out.println("Original String        : " + input);
        System.out.println("Reversed (StringBuilder): " + reversed);
        System.out.println("Reversed (Loop)         : " + reversedLoop);

        sc.close();
    }
}