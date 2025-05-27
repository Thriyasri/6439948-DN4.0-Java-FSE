import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int numberToGuess = random.nextInt(100) + 1;
        int guess;

        System.out.println("Guess a number between 1 and 100:");

        while (true) {
            guess = scanner.nextInt();

            if (guess < numberToGuess) {
                System.out.println("Too low. Try again:");
            } else if (guess > numberToGuess) {
                System.out.println("Too high. Try again:");
            } else {
                System.out.println("Correct! You guessed the number.");
                break;
            }
        }
    }
}
