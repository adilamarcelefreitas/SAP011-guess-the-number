package src;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int makeGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BEM VINDO AO GUESS THE NUMBER! O jogo vai começa com você escolhendo primeiro. Boa sorte!");
        System.out.println(name + ", dê seu palpite: ");
        int guess = scanner.nextInt();
        guesses.add(guess);
        return guess;
    }
}
