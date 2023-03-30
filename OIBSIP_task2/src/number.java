import java.util.Random;
import java.util.Scanner;
//creating class
public class number {
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);

        int min = 1; // minimum value
        int max = 100; // maximum value
        int numRounds = 2; // number of rounds
        int round = 1; // current round
        int maxAttempts = 5; // maximum number of attempts allowed per round
        int score = 0; // total score

        //starting the game
        System.out.println("Welcome to Guess the Number game!");
        System.out.println("I'm thinking of a number between 1-100...Can u guess it??");
        System.out.println("You will have 2 rounds with 5 attempts each to guess the correct number");

        // loop for each round
        while (round <= numRounds) {
            int randomno = ran.nextInt(max - min + 1) + min;
            int attempt = 1;

            // loop for each attempt
            while (attempt <= maxAttempts) {
                System.out.print("Round " + round + ", Attempt " + attempt + ": Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == randomno) {
                    int roundScore = (maxAttempts - attempt) * 10;
                    score += roundScore;
                    System.out.println("Congratulations! You guessed the number in " + attempt + " attempts.");
                    System.out.println("Round score: " + roundScore + ", Total score: " + score);
                    break;
                }
                else if (guess < randomno) {
                    System.out.println("number is lower than the expected number.");
                }
                else {
                    System.out.println("number is higher than the expected number.");
                }

                attempt++;
            }

            if (attempt > maxAttempts) {
                System.out.println("Sorry, you failed to guess the number. The number was " + randomno + ".");
            }

            round++;
        }

        //displaying final score
        System.out.println(" Your final score is: " + score);
        sc.close();
    }
}
