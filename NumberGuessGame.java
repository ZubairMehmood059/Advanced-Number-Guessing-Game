package ailab1;
import java.util.Scanner;
import java.util.Random;
public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        System.out.println("=== Welcome to Advanced Number Guessing Game ===");
        while (playAgain) {
            System.out.println("\nSelect Difficulty Level:");
            System.out.println("1. Easy (1 to 10)");
            System.out.println("2. Medium (1 to 50)");
            System.out.println("3. Hard (1 to 100)");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            int maxRange = 10;
            if (choice == 2) {
                maxRange = 50;
            } else if (choice == 3) {
                maxRange = 100;
            }
            int secretNumber = random.nextInt(maxRange) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            System.out.println("I have picked a number between 1 and " + maxRange + ". Try to guess it!");
            while (!hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed it in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }
        scanner.close();
    }
}