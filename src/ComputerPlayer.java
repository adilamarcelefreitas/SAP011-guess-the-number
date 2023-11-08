package src;
import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random = new Random();
    public ComputerPlayer(String name) {
        super(name);
    }
    @Override
    public int makeGuess() {
        int guess = random.nextInt(100) + 1;
        guesses.add(guess);
        return guess;
    }
}
