package src;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private int manualGuess = -1;

    public HumanPlayer(String name) {
        super(name);
    }

    public void setManualGuess(int guess) {
        this.manualGuess = guess;
    }

    @Override
    public int makeGuess() {
        if (manualGuess != -1) {
            getGuesses().add(manualGuess);
            return manualGuess;
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite seu palpite: ");
            int bet = scanner.nextInt();
            getGuesses().add(bet);
            return bet;
        }
    }
}