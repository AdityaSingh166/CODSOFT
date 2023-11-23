import java.util.*;


public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalRounds = 3; // You can adjust the number of rounds as needed
        int score = 0;

        for (int round = 1; round <= totalRounds; round++) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Round " + round + ": Guess the number between " + minRange + " and " + maxRange);

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += maxAttempts - attempt + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempt == maxAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                }
            }
        }

        System.out.println("Game over. Your total score is: " + score);
    }
}
