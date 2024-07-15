import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 10;
        int score = 0;
        boolean playAgain = true;
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        while (playAgain) {
            int randomNumber = random.nextInt(MAX - MIN + 1) + MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("\nI'm thinking of a number between " + MIN + " and " + MAX + ". Can you guess it?");
            
            while (!guessedCorrectly && attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + "): ");
                int guess;
                
                // Validate input
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                    if (guess < MIN || guess > MAX) {
                        System.out.println("Please enter a valid number between " + MIN + " and " + MAX + ".");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
                
                attempts++;
                
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you did not guess the number. It was " + randomNumber + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playResponse = scanner.nextLine().toLowerCase();
            playAgain = playResponse.equals("yes") || playResponse.equals("y");
        }
        
        System.out.println("\nGame Over. Your total score is " + score + ". Thanks for playing!");
        scanner.close();
    }
}
