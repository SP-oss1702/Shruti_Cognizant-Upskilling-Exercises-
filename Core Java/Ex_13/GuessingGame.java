import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int randomNumber = rand.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("I have picked a number between 1 and 100.");
        System.out.println("Try to guess it!");
        System.out.println();

        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too Low! Try higher.");
            } else if (guess > randomNumber) {
                System.out.println("Too High! Try lower.");
            } else {
                System.out.println();
                System.out.println("🎉 Correct! The number was " + randomNumber);
                System.out.println("You got it in " + attempts + " attempts!");
            }

        } while (guess != randomNumber);

        sc.close();
    }
}