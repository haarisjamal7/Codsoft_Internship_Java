import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 7;
        int Score = 0;

        boolean playAgain = true;

        while (playAgain) {
            int target = random.nextInt(100) + 1;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100. You have " + maxAttempts + " attempts.");

            int attempts = 0;
            boolean isCorrect = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int Guess = scanner.nextInt();

                if (Guess == target) {
                    isCorrect = true;
                    break;
                } else if (Guess < target) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                attempts++;
            }

            if (isCorrect) {
                System.out.println("Congratulations! You guessed the correct number: " + target);
                Score++;
            } else {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + target);
            }

            System.out.println("Your current score: " + Score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();

            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
    }
}
