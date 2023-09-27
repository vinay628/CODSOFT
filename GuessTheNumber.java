import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerValue = 1;
        int upperValue = 100;
        int maxAttempts = 10;
        int secretNumber;
        int userGuess;
        int attempts;
        int score = 0;

        System.out.println("Welcome to Guess the Number!");
        
        do {
            secretNumber = random.nextInt(upperValue - lowerValue + 1) + lowerValue;
            attempts = 0;

            System.out.println("I'm thinking of a number between " + lowerValue + " and " + upperValue + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                try {
                    userGuess = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input from the scanner
                    continue;
                }

                attempts++;

                if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    score++;
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The secret number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            String playAgain = scanner.next();

            if (!playAgain.toLowerCase().equals("y")) {
                break;
            }
        } while (true);

        System.out.println("Thank you for playing! Your score is " + score + " rounds won.");
    }
}
