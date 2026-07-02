import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int round = 1;
        String playAgain = "yes";

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        while (playAgain.equalsIgnoreCase("yes")) {

            System.out.println("\nRound " + round);

            System.out.println("Choose Difficulty:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            int maxNumber = 100;
            int maxAttempts = 7;

            if (choice == 1) {
                maxNumber = 50;
                maxAttempts = 10;
            } else if (choice == 2) {
                maxNumber = 100;
                maxAttempts = 7;
            } else if (choice == 3) {
                maxNumber = 200;
                maxAttempts = 5;
            } else {
                System.out.println("Invalid choice. Default Medium selected.");
            }

            int secretNumber = random.nextInt(maxNumber) + 1;

            boolean guessed = false;

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("Attempt " + attempt + "/" + maxAttempts + " Enter your guess: ");

                int guess = sc.nextInt();

                if (guess == secretNumber) {

                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Round " + round + " completed in " + attempt + " attempts.");
                    guessed = true;
                    break;

                } else if (guess < secretNumber) {

                    System.out.println("Too Low!");

                } else {

                    System.out.println("Too High!");

                }
            }

            if (!guessed) {

                System.out.println("You Lost!");
                System.out.println("The correct number was: " + secretNumber);

            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = sc.next();

            round++;
        }

        System.out.println("\nThank you for playing!");

        sc.close();
    }
